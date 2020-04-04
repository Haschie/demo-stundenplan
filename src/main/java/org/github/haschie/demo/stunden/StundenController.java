package org.github.haschie.demo.stunden;

import org.github.haschie.demo.stunden.model.Stunden;
import org.github.haschie.demo.stunden.model.StundenRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;


@RestControllerAdvice
@RequestMapping("/stunden")
public class StundenController {

    private static Logger logger = LoggerFactory.getLogger(StundenController.class);

    private static StundenRepository repository;

    public StundenController(StundenRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity post(@NotNull @RequestBody StundenDTO dto, UriComponentsBuilder uriBuilder){
        final UUID uuid = UUID.randomUUID();

        Stunden entity = new Stunden(uuid, dto.getStunde(), dto.getWochentag(), dto.getFach(), dto.getLehrer());
        repository.save(entity);

        UriComponents components = uriBuilder.path("/stunden/{id}").buildAndExpand(uuid);
        return ResponseEntity.created(components.toUri()).build();
    }

    @GetMapping("/{uuid}")
    @ResponseBody
    public ResponseEntity<Stunden> get(@PathVariable("uuid") UUID uuid){
        logger.info(String.format("GET /stunden/{%s}", uuid));

        Stunden stunden = repository.findByUuid(uuid);
        if(stunden == null) {
            return ResponseEntity.notFound().build();
        }

        logger.info(String.format("Stunden ermittelt. %s", stunden));
        return ResponseEntity.ok(stunden);
    }

}

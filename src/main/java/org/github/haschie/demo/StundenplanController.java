package org.github.haschie.demo;

import org.github.haschie.demo.model.Stundenplan;
import org.github.haschie.demo.model.StundenplanRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/stundenplan")
public class StundenplanController {

    private static Logger logger = LoggerFactory.getLogger(StundenplanController.class);

    private final StundenplanRepository repository;

    public StundenplanController(StundenplanRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity post(@NotNull @RequestBody StundenplanDTO dto, UriComponentsBuilder uriBuilder) {

        final UUID uuid = UUID.randomUUID();
        Stundenplan entity = new Stundenplan(uuid, dto.getSchueler(), dto.getVon(), dto.getBis());
        repository.save(entity);

        UriComponents components = uriBuilder.path("/stundenplan/{id}").buildAndExpand(uuid);
        return ResponseEntity.created(components.toUri()).build();
    }

    @GetMapping("/{uuid}")
    @ResponseBody
    public ResponseEntity<Stundenplan> get(@PathVariable("uuid") UUID uuid) {
        logger.info(String.format("GET /stundenplan/{%s}", uuid));

        Stundenplan stundenplan = repository.findByUuid(uuid);
        if (stundenplan == null) {
            return ResponseEntity.notFound().build();
        }

        logger.info(String.format("Stundenplan ermittelt. %s", stundenplan));
        return ResponseEntity.ok(stundenplan);
    }
}

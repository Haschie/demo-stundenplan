package org.github.haschie.demo.model;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StundenplanRepository extends CrudRepository<Stundenplan, UUID> {

    Stundenplan findByUuid(UUID ID);
    Stundenplan findBySchueler(String schueler);
}

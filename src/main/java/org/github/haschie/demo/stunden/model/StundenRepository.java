package org.github.haschie.demo.stunden.model;

import org.github.haschie.demo.stundenplan.model.Stundenplan;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StundenRepository extends CrudRepository<Stunden, UUID> {

    Stunden findByUuid(UUID ID);
}


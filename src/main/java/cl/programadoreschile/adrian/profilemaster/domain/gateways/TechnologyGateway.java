package cl.programadoreschile.adrian.profilemaster.domain.gateways;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Technology;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyId;

import java.util.List;
import java.util.Optional;

public interface TechnologyGateway {

    List<Technology> getAll();

    Optional<Technology> getById(TechnologyId id);

    Technology save(Technology technology);

    void deleteById(TechnologyId id);

}

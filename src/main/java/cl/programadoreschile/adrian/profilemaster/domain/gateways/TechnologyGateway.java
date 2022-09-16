package cl.programadoreschile.adrian.profilemaster.domain.gateways;

import cl.programadoreschile.adrian.profilemaster.domain.entities.TechnologyDTO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyID;

import java.util.List;
import java.util.Optional;

public interface TechnologyGateway {

    List<TechnologyDTO> getAll();

    Optional<TechnologyDTO> getById(TechnologyID id);

    TechnologyDTO save(TechnologyDTO technology);

    void deleteById(TechnologyID id);

}

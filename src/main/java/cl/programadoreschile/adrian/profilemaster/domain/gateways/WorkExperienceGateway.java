package cl.programadoreschile.adrian.profilemaster.domain.gateways;

import cl.programadoreschile.adrian.profilemaster.domain.entities.WorkExperienceDTO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.WorkExperienceID;

import java.util.List;
import java.util.Optional;

public interface WorkExperienceGateway {

    List<WorkExperienceDTO> getAll();

    Optional<WorkExperienceDTO> getById(WorkExperienceID id);

    WorkExperienceDTO save(WorkExperienceDTO technology);

    void deleteById(WorkExperienceID id);

}

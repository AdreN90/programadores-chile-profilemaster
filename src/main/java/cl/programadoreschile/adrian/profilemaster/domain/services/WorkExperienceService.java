package cl.programadoreschile.adrian.profilemaster.domain.services;

import cl.programadoreschile.adrian.profilemaster.domain.entities.WorkExperienceDTO;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.WorkExperienceGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.models.WorkExperienceID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkExperienceService {

    @Autowired
    private WorkExperienceGateway gateway;

    public List<WorkExperienceDTO> getAll() {
        return gateway.getAll();
    }

    public Optional<WorkExperienceDTO> getById(WorkExperienceID id) {
        return gateway.getById(id);
    }

    public WorkExperienceDTO save(WorkExperienceDTO technology) {
        return gateway.save(technology);
    }

    public void deleteById(WorkExperienceID id) {
        gateway.deleteById(id);
    }
}

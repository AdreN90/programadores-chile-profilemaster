package cl.programadoreschile.adrian.profilemaster.persistence;

import cl.programadoreschile.adrian.profilemaster.domain.entities.WorkExperienceDTO;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.WorkExperienceGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.crud.WorkExperienceCrudRepository;
import cl.programadoreschile.adrian.profilemaster.persistence.mappers.WorkExperienceMapper;
import cl.programadoreschile.adrian.profilemaster.persistence.models.WorkExperienceDAO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.WorkExperienceID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class WorkExperienceRepository implements WorkExperienceGateway {

    @Autowired
    private WorkExperienceCrudRepository crudRepository;

    @Autowired
    private WorkExperienceMapper mapper;

    @Override
    public List<WorkExperienceDTO> getAll() {
        final List<WorkExperienceDAO> workExperiences = (List<WorkExperienceDAO>) crudRepository.findAll();
        return mapper.toWorkExperiences(workExperiences);
    }

    @Override
    public Optional<WorkExperienceDTO> getById(WorkExperienceID id) {
        return crudRepository.findById(id)
                .map(workExperience -> mapper.toWorkExperience(workExperience));
    }

    @Override
    public List<WorkExperienceDTO> getByIdPerson(String idPerson) {
        final Optional<List<WorkExperienceDAO>> workExperiences = crudRepository.findByIdPersonEqualsIgnoreCase(idPerson);
        return workExperiences.map(workExperience -> mapper.toWorkExperiences(workExperience))
                .orElse(new ArrayList<>());
    }

    @Override
    public WorkExperienceDTO save(WorkExperienceDTO workExperience) {
        WorkExperienceDAO workExperienceDAO = mapper.toWorkExperienceDAO(workExperience);
        return mapper.toWorkExperience(crudRepository.save(workExperienceDAO));
    }

    @Override
    public void deleteById(WorkExperienceID id) {
        crudRepository.deleteById(id);
    }

}

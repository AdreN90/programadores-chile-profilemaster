package cl.programadoreschile.adrian.profilemaster.persistence.crud;

import cl.programadoreschile.adrian.profilemaster.persistence.models.WorkExperienceDAO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.WorkExperienceID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkExperienceCrudRepository extends CrudRepository<WorkExperienceDAO, WorkExperienceID> {

    Optional<List<WorkExperienceDAO>> findByIdPersonContaining(String idPerson);

}

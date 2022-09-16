package cl.programadoreschile.adrian.profilemaster.persistence.crud;

import cl.programadoreschile.adrian.profilemaster.persistence.models.WorkExperienceDAO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.WorkExperienceID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceCrudRepository extends CrudRepository<WorkExperienceDAO, WorkExperienceID> {
}

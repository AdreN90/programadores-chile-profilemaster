package cl.programadoreschile.adrian.profilemaster.persistence.crud;

import cl.programadoreschile.adrian.profilemaster.persistence.models.AcademicInfoDAO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.AcademicInfoID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicInfoCrudRepository extends CrudRepository<AcademicInfoDAO, AcademicInfoID> {
}

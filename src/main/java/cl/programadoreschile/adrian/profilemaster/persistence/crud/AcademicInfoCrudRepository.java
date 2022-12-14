package cl.programadoreschile.adrian.profilemaster.persistence.crud;

import cl.programadoreschile.adrian.profilemaster.persistence.models.AcademicInfoDAO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.AcademicInfoID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AcademicInfoCrudRepository extends CrudRepository<AcademicInfoDAO, AcademicInfoID> {

    Optional<List<AcademicInfoDAO>> findByIdPersonEqualsIgnoreCase(String idPerson);
    Optional<List<AcademicInfoDAO>> findByTypeEducationEqualsIgnoreCase(String typeEducation);

}

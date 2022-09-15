package cl.programadoreschile.adrian.profilemaster.persistence.crud;

import cl.programadoreschile.adrian.profilemaster.persistence.models.PersonDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCrudRepository extends CrudRepository<PersonDAO, String> {
}

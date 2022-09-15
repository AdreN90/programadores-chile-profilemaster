package cl.programadoreschile.adrian.profilemaster.persistence.crud;

import cl.programadoreschile.adrian.profilemaster.persistence.models.PersonDAO;
import org.springframework.data.repository.CrudRepository;

public interface PersonCrudRepository extends CrudRepository<PersonDAO, Integer> {
}

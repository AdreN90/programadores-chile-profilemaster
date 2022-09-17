package cl.programadoreschile.adrian.profilemaster.persistence.crud;

import cl.programadoreschile.adrian.profilemaster.persistence.models.PersonDAO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonCrudRepository extends CrudRepository<PersonDAO, String> {

    Optional<List<PersonDAO>> findByCityContaining(String city);

    Optional<List<PersonDAO>> findByCountryContaining(String country);

    Optional<List<PersonDAO>> findByChangeOfAddressEquals(boolean changeOfAddress);

}

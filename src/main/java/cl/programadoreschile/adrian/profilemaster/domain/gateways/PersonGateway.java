package cl.programadoreschile.adrian.profilemaster.domain.gateways;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonGateway {

    List<Person> getAll();

    Optional<Person> getById(String id);

    Person save(Person person);

    void deleteById(String id);

}

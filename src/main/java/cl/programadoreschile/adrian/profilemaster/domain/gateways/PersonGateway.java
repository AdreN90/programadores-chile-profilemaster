package cl.programadoreschile.adrian.profilemaster.domain.gateways;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Person;

import java.util.List;
import java.util.Optional;

public interface PersonGateway {

    List<Person> getAll();

    Optional<Person> getPersonById(String idPerson);

    Person save(Person person);

    void deletePersonById(String idPerson);

}

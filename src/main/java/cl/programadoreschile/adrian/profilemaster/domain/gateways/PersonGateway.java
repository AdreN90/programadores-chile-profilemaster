package cl.programadoreschile.adrian.profilemaster.domain.gateways;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Person;
import cl.programadoreschile.adrian.profilemaster.persistence.models.PersonDAO;

import java.util.List;

public interface PersonGateway {

    List<PersonDAO> getAll();

    Person save(Person usuario);

}

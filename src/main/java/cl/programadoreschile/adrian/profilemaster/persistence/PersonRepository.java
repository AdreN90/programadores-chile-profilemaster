package cl.programadoreschile.adrian.profilemaster.persistence;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Person;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.PersonGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.crud.PersonCrudRepository;
import cl.programadoreschile.adrian.profilemaster.persistence.models.PersonDAO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static cl.programadoreschile.adrian.profilemaster.persistence.mappers.GenericMapper.transformObject;

@Repository
@AllArgsConstructor
public class PersonRepository implements PersonGateway {

    @Autowired
    private PersonCrudRepository crudRepository;

    @Override
    public List<PersonDAO> getAll() {
        return (List<PersonDAO>) crudRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        PersonDAO personDAO = transformObject(person, PersonDAO.class);
        return transformObject(crudRepository.save(personDAO), Person.class);
    }
}

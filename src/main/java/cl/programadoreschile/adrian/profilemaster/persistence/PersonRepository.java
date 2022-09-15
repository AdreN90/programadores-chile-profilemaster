package cl.programadoreschile.adrian.profilemaster.persistence;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Person;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.PersonGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.crud.PersonCrudRepository;
import cl.programadoreschile.adrian.profilemaster.persistence.mappers.PersonMapper;
import cl.programadoreschile.adrian.profilemaster.persistence.models.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository implements PersonGateway {

    @Autowired
    private PersonCrudRepository crudRepository;

    @Autowired
    private PersonMapper mapper;

    @Override
    public List<Person> getAll() {
        final List<PersonDAO> persons = (List<PersonDAO>) crudRepository.findAll();
        return mapper.toPersons(persons);
    }

    @Override
    public Optional<Person> getPersonById(String idPerson) {
        return crudRepository.findById(idPerson)
                .map(person -> mapper.toPerson(person));
    }

    @Override
    public Person save(Person person) {
        PersonDAO personDAO = mapper.toPersonDAO(person);
        return mapper.toPerson(crudRepository.save(personDAO));
    }
}

package cl.programadoreschile.adrian.profilemaster.persistence;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Person;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.PersonGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.crud.PersonCrudRepository;
import cl.programadoreschile.adrian.profilemaster.persistence.mappers.PersonMapper;
import cl.programadoreschile.adrian.profilemaster.persistence.models.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository implements PersonGateway {

    @Autowired
    private PersonCrudRepository crudRepository;

    @Autowired
    private PersonMapper mapper;

    @Override
    public List<PersonDAO> getAll() {
        return (List<PersonDAO>) crudRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        PersonDAO personDAO = mapper.toPersonDAO(person);
        return mapper.toPerson(crudRepository.save(personDAO));
    }
}

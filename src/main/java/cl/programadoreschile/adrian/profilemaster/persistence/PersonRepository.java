package cl.programadoreschile.adrian.profilemaster.persistence;

import cl.programadoreschile.adrian.profilemaster.domain.entities.PersonDTO;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.PersonGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.crud.PersonCrudRepository;
import cl.programadoreschile.adrian.profilemaster.persistence.mappers.PersonMapper;
import cl.programadoreschile.adrian.profilemaster.persistence.models.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository implements PersonGateway {

    @Autowired
    private PersonCrudRepository crudRepository;

    @Autowired
    private PersonMapper mapper;

    @Override
    public List<PersonDTO> getAll() {
        final List<PersonDAO> persons = (List<PersonDAO>) crudRepository.findAll();
        return mapper.toPersons(persons);
    }

    @Override
    public Optional<PersonDTO> getById(String id) {
        return crudRepository.findById(id)
                .map(person -> mapper.toPerson(person));
    }

    @Override
    public List<PersonDTO> getByCity(String city) {
        return crudRepository.findByCityEqualsIgnoreCase(city)
                .map(persons -> mapper.toPersons(persons))
                .orElse(new ArrayList<>());
    }

    @Override
    public List<PersonDTO> getByCountry(String country) {
        return crudRepository.findByCountryEqualsIgnoreCase(country)
                .map(persons -> mapper.toPersons(persons))
                .orElse(new ArrayList<>());
    }

    @Override
    public List<PersonDTO> getByChangeOfAddress(boolean changeOfAddress) {
        return crudRepository.findByChangeOfAddressEquals(changeOfAddress)
                .map(persons -> mapper.toPersons(persons))
                .orElse(new ArrayList<>());
    }

    @Override
    public PersonDTO save(PersonDTO person) {
        PersonDAO personDAO = mapper.toPersonDAO(person);
        return mapper.toPerson(crudRepository.save(personDAO));
    }

    @Override
    public void deleteById(String id) {
        crudRepository.deleteById(id);
    }
}

package cl.programadoreschile.adrian.profilemaster.domain.services;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Person;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.PersonGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonGateway gateway;

    public List<Person> getAll() {
        return gateway.getAll();
    }

    public Optional<Person> getPersonById(String idPerson) {
        return gateway.getPersonById(idPerson);
    }

    public Person save(Person person) {
        return gateway.save(person);
    }

    public void deleteById(String idPerson){
        gateway.deletePersonById(idPerson);
    }
}

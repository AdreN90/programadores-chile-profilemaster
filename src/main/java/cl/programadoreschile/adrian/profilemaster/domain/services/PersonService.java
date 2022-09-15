package cl.programadoreschile.adrian.profilemaster.domain.services;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Person;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.PersonGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.models.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonGateway gateway;

    public List<PersonDAO> getAll() {
        return gateway.getAll();
    }

    public Person save(Person person){
        return gateway.save(person);
    }
}

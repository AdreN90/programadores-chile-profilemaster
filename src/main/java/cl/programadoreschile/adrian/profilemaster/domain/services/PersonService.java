package cl.programadoreschile.adrian.profilemaster.domain.services;

import cl.programadoreschile.adrian.profilemaster.domain.entities.PersonDTO;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.PersonGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonGateway gateway;

    public List<PersonDTO> getAll() {
        return gateway.getAll();
    }

    public Optional<PersonDTO> getById(String idPerson) {
        return gateway.getById(idPerson);
    }

    public List<PersonDTO> getByCity(String city) {
        return gateway.getByCity(city);
    }

    public List<PersonDTO> getByCountry(String country) {
        return gateway.getByCountry(country);
    }
    public List<PersonDTO> getByChangeOfAddress(boolean changeOfAddress) {
        return gateway.getByChangeOfAddress(changeOfAddress);
    }

    public PersonDTO save(PersonDTO person) {
        return gateway.save(person);
    }

    public void deleteById(String idPerson) {
        gateway.deleteById(idPerson);
    }
}

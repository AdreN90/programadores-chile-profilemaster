package cl.programadoreschile.adrian.profilemaster.domain.gateways;

import cl.programadoreschile.adrian.profilemaster.domain.entities.PersonDTO;

import java.util.List;
import java.util.Optional;

public interface PersonGateway {

    List<PersonDTO> getAll();

    Optional<PersonDTO> getById(String id);

    List<PersonDTO> getByCity(String city);

    List<PersonDTO> getByCountry(String country);

    List<PersonDTO> getByChangeOfAddress(boolean changeOfAddress);

    PersonDTO save(PersonDTO person);

    void deleteById(String id);

}

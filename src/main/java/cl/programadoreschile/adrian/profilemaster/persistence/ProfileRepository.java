package cl.programadoreschile.adrian.profilemaster.persistence;

import cl.programadoreschile.adrian.profilemaster.domain.entities.PersonDTO;
import cl.programadoreschile.adrian.profilemaster.domain.entities.ProfileDTO;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.ProfileGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.crud.PersonCrudRepository;
import cl.programadoreschile.adrian.profilemaster.persistence.mappers.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProfileRepository implements ProfileGateway {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<ProfileDTO> getAll() {
        final List<PersonDTO> persons = personRepository.getAll();
        return persons.stream()
                .map(this::setProfile)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProfileDTO> getById(String id) {
        final Optional<PersonDTO> person = personRepository.getById(id);
        return person.map(this::setProfile);
    }

    private ProfileDTO setProfile(PersonDTO person) {
        return new ProfileDTO()
                .setPerson(person);
    }

}

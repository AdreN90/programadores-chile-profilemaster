package cl.programadoreschile.adrian.profilemaster.persistence;

import cl.programadoreschile.adrian.profilemaster.domain.entities.PersonDTO;
import cl.programadoreschile.adrian.profilemaster.domain.entities.ProfileDTO;
import cl.programadoreschile.adrian.profilemaster.domain.entities.TechnologyDTO;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.ProfileGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProfileRepository implements ProfileGateway {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TechnologyRepository technologyRepository;

    @Override
    public List<ProfileDTO> getAll() {
        final List<PersonDTO> persons = personRepository.getAll();
        return persons.stream()
                .map(this::setProfile)
                .toList();
    }

    @Override
    public Optional<ProfileDTO> getById(String id) {
        final Optional<PersonDTO> person = personRepository.getById(id);
        return person.map(this::setProfile);
    }

    @Override
    public List<ProfileDTO> getByCity(String city) {
        final List<PersonDTO> persons = personRepository.getByCity(city);
        return persons.stream()
                .map(this::setProfile)
                .toList();
    }

    @Override
    public List<ProfileDTO> getByCountry(String country) {
        final List<PersonDTO> persons = personRepository.getByCountry(country);
        return persons.stream()
                .map(this::setProfile)
                .toList();
    }

    @Override
    public List<ProfileDTO> getByChangeOfAddress(boolean changeOfAddress) {
        final List<PersonDTO> persons = personRepository.getByChangeOfAddress(changeOfAddress);
        return persons.stream()
                .map(this::setProfile)
                .toList();
    }

    private ProfileDTO setProfile(PersonDTO person) {
        final List<TechnologyDTO> technologies = technologyRepository.getByIdPerson(person.getIdPerson());
        return new ProfileDTO()
                .setPerson(person)
                .setTechnology(technologies);
    }

}

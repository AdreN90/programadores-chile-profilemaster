package cl.programadoreschile.adrian.profilemaster.persistence.mappers;

import cl.programadoreschile.adrian.profilemaster.domain.entities.PersonDTO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.PersonDAO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface PersonMapper {

    PersonDAO toPersonDAO(PersonDTO person);

    PersonDTO toPerson(PersonDAO personDAO);

    List<PersonDTO> toPersons(List<PersonDAO> persons);

}

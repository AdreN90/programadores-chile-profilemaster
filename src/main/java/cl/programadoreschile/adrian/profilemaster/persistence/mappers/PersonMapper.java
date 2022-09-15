package cl.programadoreschile.adrian.profilemaster.persistence.mappers;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Person;
import cl.programadoreschile.adrian.profilemaster.persistence.models.PersonDAO;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface PersonMapper {

    PersonDAO toPersonDAO(Person person);

    Person toPerson(PersonDAO personDAO);

}

package cl.programadoreschile.adrian.profilemaster.persistence.mappers;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Technology;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyDAO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface TechnologyMapper {

    TechnologyDAO toTechnologyDAO(Technology technology);

    Technology toTechnology(TechnologyDAO technologyDAO);

    List<Technology> toTechnologies(List<TechnologyDAO> technologies);

}

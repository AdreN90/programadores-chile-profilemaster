package cl.programadoreschile.adrian.profilemaster.persistence.mappers;

import cl.programadoreschile.adrian.profilemaster.domain.entities.TechnologyDTO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyDAO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface TechnologyMapper {

    TechnologyDAO toTechnologyDAO(TechnologyDTO technology);

    TechnologyDTO toTechnology(TechnologyDAO technologyDAO);

    List<TechnologyDTO> toTechnologies(List<TechnologyDAO> technologies);

}

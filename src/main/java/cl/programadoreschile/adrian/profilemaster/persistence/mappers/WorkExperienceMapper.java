package cl.programadoreschile.adrian.profilemaster.persistence.mappers;

import cl.programadoreschile.adrian.profilemaster.domain.entities.WorkExperienceDTO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.WorkExperienceDAO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface WorkExperienceMapper {

    WorkExperienceDAO toWorkExperienceDAO(WorkExperienceDTO workExperience);

    WorkExperienceDTO toWorkExperience(WorkExperienceDAO workExperienceDAO);

    List<WorkExperienceDTO> toWorkExperiences(List<WorkExperienceDAO> workExperiences);

}

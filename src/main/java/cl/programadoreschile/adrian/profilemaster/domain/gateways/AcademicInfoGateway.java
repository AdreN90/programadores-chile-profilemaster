package cl.programadoreschile.adrian.profilemaster.domain.gateways;

import cl.programadoreschile.adrian.profilemaster.domain.entities.AcademicInfoDTO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.AcademicInfoID;

import java.util.List;
import java.util.Optional;

public interface AcademicInfoGateway {

    List<AcademicInfoDTO> getAll();

    Optional<AcademicInfoDTO> getById(AcademicInfoID id);

    List<AcademicInfoDTO> getByIdPerson(String idPerson);

    List<AcademicInfoDTO> getByTypeEducation(String typeEducation);

    AcademicInfoDTO save(AcademicInfoDTO academicInfo);

    void deleteById(AcademicInfoID id);

}

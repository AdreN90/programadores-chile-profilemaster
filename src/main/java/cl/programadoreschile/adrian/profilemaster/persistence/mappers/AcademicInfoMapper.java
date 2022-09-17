package cl.programadoreschile.adrian.profilemaster.persistence.mappers;

import cl.programadoreschile.adrian.profilemaster.domain.entities.AcademicInfoDTO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.AcademicInfoDAO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface AcademicInfoMapper {

    AcademicInfoDAO toAcademicInfoDAO(AcademicInfoDTO academicInfo);

    AcademicInfoDTO toAcademicInfo(AcademicInfoDAO academicInfoDAO);

    List<AcademicInfoDTO> toAcademicInfoList(List<AcademicInfoDAO> academicInfoList);

}

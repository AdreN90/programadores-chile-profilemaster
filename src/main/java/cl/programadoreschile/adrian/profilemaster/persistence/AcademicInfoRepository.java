package cl.programadoreschile.adrian.profilemaster.persistence;

import cl.programadoreschile.adrian.profilemaster.domain.entities.AcademicInfoDTO;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.AcademicInfoGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.crud.AcademicInfoCrudRepository;
import cl.programadoreschile.adrian.profilemaster.persistence.mappers.AcademicInfoMapper;
import cl.programadoreschile.adrian.profilemaster.persistence.models.AcademicInfoDAO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.AcademicInfoID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AcademicInfoRepository implements AcademicInfoGateway {

    @Autowired
    private AcademicInfoCrudRepository crudRepository;

    @Autowired
    private AcademicInfoMapper mapper;

    @Override
    public List<AcademicInfoDTO> getAll() {
        final List<AcademicInfoDAO> academicInfoList = (List<AcademicInfoDAO>) crudRepository.findAll();
        return mapper.toAcademicInfoList(academicInfoList);
    }

    @Override
    public Optional<AcademicInfoDTO> getById(AcademicInfoID id) {
        return crudRepository.findById(id)
                .map(academicInfo -> mapper.toAcademicInfo(academicInfo));
    }

    @Override
    public List<AcademicInfoDTO> getByIdPerson(String idPerson) {
        final Optional<List<AcademicInfoDAO>> academicInfoList = crudRepository.findByIdPersonContaining(idPerson);
        return academicInfoList.map(academicInfo -> mapper.toAcademicInfoList(academicInfo))
                .orElse(new ArrayList<>());
    }

    @Override
    public AcademicInfoDTO save(AcademicInfoDTO academicInfo) {
        AcademicInfoDAO academicInfoDAO = mapper.toAcademicInfoDAO(academicInfo);
        return mapper.toAcademicInfo(crudRepository.save(academicInfoDAO));
    }

    @Override
    public void deleteById(AcademicInfoID id) {
        crudRepository.deleteById(id);
    }

}

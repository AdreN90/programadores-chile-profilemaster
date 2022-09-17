package cl.programadoreschile.adrian.profilemaster.domain.services;

import cl.programadoreschile.adrian.profilemaster.domain.entities.AcademicInfoDTO;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.AcademicInfoGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.models.AcademicInfoID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicInfoService {

    @Autowired
    private AcademicInfoGateway gateway;

    public List<AcademicInfoDTO> getAll() {
        return gateway.getAll();
    }

    public Optional<AcademicInfoDTO> getById(AcademicInfoID id) {
        return gateway.getById(id);
    }

    public AcademicInfoDTO save(AcademicInfoDTO academicInfo) {
        return gateway.save(academicInfo);
    }

    public void deleteById(AcademicInfoID id) {
        gateway.deleteById(id);
    }
}

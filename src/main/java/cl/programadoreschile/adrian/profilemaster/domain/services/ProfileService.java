package cl.programadoreschile.adrian.profilemaster.domain.services;

import cl.programadoreschile.adrian.profilemaster.domain.entities.ProfileDTO;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.ProfileGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileGateway gateway;

    public List<ProfileDTO> getAll() {
        return gateway.getAll();
    }

    public Optional<ProfileDTO> getById(String idPerson) {
        return gateway.getById(idPerson);
    }

}

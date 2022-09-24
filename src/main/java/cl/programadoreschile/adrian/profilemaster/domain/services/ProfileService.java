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

    public List<ProfileDTO> getByCity(String city) {
        return gateway.getByCity(city);
    }

    public List<ProfileDTO> getByCountry(String country) {
        return gateway.getByCountry(country);
    }

    public List<ProfileDTO> getByChangeOfAddress(boolean changeOfAddress) {
        return gateway.getByChangeOfAddress(changeOfAddress);
    }

    public List<ProfileDTO> getByTypeEducation(String typeEducation) {
        return gateway.getByTypeEducation(typeEducation);
    }

    public List<ProfileDTO> getByTechnology(String technology) {
        return gateway.getByTechnology(technology);
    }

}

package cl.programadoreschile.adrian.profilemaster.domain.gateways;

import cl.programadoreschile.adrian.profilemaster.domain.entities.ProfileDTO;

import java.util.List;
import java.util.Optional;

public interface ProfileGateway {

    List<ProfileDTO> getAll();

    Optional<ProfileDTO> getById(String id);

    List<ProfileDTO> getByCity(String city);

    List<ProfileDTO> getByCountry(String country);

    List<ProfileDTO> getByChangeOfAddress(boolean changeOfAddress);

}

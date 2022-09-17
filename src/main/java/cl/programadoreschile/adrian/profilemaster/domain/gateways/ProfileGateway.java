package cl.programadoreschile.adrian.profilemaster.domain.gateways;

import cl.programadoreschile.adrian.profilemaster.domain.entities.ProfileDTO;

import java.util.List;
import java.util.Optional;

public interface ProfileGateway {

    List<ProfileDTO> getAll();

    Optional<ProfileDTO> getById(String id);

}

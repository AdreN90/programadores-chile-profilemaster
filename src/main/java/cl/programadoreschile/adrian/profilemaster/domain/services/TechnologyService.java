package cl.programadoreschile.adrian.profilemaster.domain.services;

import cl.programadoreschile.adrian.profilemaster.domain.entities.TechnologyDTO;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.TechnologyGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnologyService {

    @Autowired
    private TechnologyGateway gateway;

    public List<TechnologyDTO> getAll() {
        return gateway.getAll();
    }

    public Optional<TechnologyDTO> getById(TechnologyID id) {
        return gateway.getById(id);
    }

    public List<TechnologyDTO> getByIdPerson(String idPerson) {
        return gateway.getByIdPerson(idPerson);
    }

    public List<TechnologyDTO> getByTechnology(String technology) {
        return gateway.getByTechnology(technology);
    }

    public TechnologyDTO save(TechnologyDTO technology) {
        return gateway.save(technology);
    }

    public void deleteById(TechnologyID id) {
        gateway.deleteById(id);
    }
}

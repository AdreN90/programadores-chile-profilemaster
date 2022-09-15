package cl.programadoreschile.adrian.profilemaster.domain.services;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Technology;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.TechnologyGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnologyService {

    @Autowired
    private TechnologyGateway gateway;

    public List<Technology> getAll() {
        return gateway.getAll();
    }

    public Optional<Technology> getById(TechnologyId id) {
        return gateway.getById(id);
    }

    public Technology save(Technology technology) {
        return gateway.save(technology);
    }

    public void deleteById(TechnologyId id) {
        gateway.deleteById(id);
    }
}

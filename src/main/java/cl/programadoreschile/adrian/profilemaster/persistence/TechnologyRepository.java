package cl.programadoreschile.adrian.profilemaster.persistence;

import cl.programadoreschile.adrian.profilemaster.domain.entities.Technology;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.TechnologyGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.crud.TechnologyCrudRepository;
import cl.programadoreschile.adrian.profilemaster.persistence.mappers.TechnologyMapper;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyDAO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TechnologyRepository implements TechnologyGateway {

    @Autowired
    private TechnologyCrudRepository crudRepository;

    @Autowired
    private TechnologyMapper mapper;

    @Override
    public List<Technology> getAll() {
        final List<TechnologyDAO> technologies = (List<TechnologyDAO>) crudRepository.findAll();
        return mapper.toTechnologies(technologies);
    }

    @Override
    public Optional<Technology> getById(TechnologyId id) {
        return crudRepository.findById(id)
                .map(technology -> mapper.toTechnology(technology));
    }

    @Override
    public Technology save(Technology technology) {
        TechnologyDAO technologyDAO = mapper.toTechnologyDAO(technology);
        return mapper.toTechnology(crudRepository.save(technologyDAO));
    }

    @Override
    public void deleteById(TechnologyId id) {
        crudRepository.deleteById(id);
    }
}

package cl.programadoreschile.adrian.profilemaster.persistence;

import cl.programadoreschile.adrian.profilemaster.domain.entities.TechnologyDTO;
import cl.programadoreschile.adrian.profilemaster.domain.gateways.TechnologyGateway;
import cl.programadoreschile.adrian.profilemaster.persistence.crud.TechnologyCrudRepository;
import cl.programadoreschile.adrian.profilemaster.persistence.mappers.TechnologyMapper;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyDAO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TechnologyRepository implements TechnologyGateway {

    @Autowired
    private TechnologyCrudRepository crudRepository;

    @Autowired
    private TechnologyMapper mapper;

    @Override
    public List<TechnologyDTO> getAll() {
        final List<TechnologyDAO> technologies = (List<TechnologyDAO>) crudRepository.findAll();
        return mapper.toTechnologies(technologies);
    }

    @Override
    public Optional<TechnologyDTO> getById(TechnologyID id) {
        return crudRepository.findById(id)
                .map(technology -> mapper.toTechnology(technology));
    }

    @Override
    public List<TechnologyDTO> getByIdPerson(String idPerson) {
        final Optional<List<TechnologyDAO>> technologies = crudRepository.findByIdPersonEqualsIgnoreCase(idPerson);
        return technologies.map(technology -> mapper.toTechnologies(technology))
                .orElse(new ArrayList<>());
    }

    @Override
    public List<TechnologyDTO> getByTechnology(String tech) {
        final Optional<List<TechnologyDAO>> technologies = crudRepository.findByTechnologyContainingIgnoreCase(tech);
        return technologies.map(technology -> mapper.toTechnologies(technology))
                .orElse(new ArrayList<>());
    }

    @Override
    public TechnologyDTO save(TechnologyDTO technology) {
        TechnologyDAO technologyDAO = mapper.toTechnologyDAO(technology);
        return mapper.toTechnology(crudRepository.save(technologyDAO));
    }

    @Override
    public void deleteById(TechnologyID id) {
        crudRepository.deleteById(id);
    }
}

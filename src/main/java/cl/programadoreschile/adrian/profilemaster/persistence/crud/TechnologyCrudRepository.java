package cl.programadoreschile.adrian.profilemaster.persistence.crud;

import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyDAO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TechnologyCrudRepository extends CrudRepository<TechnologyDAO, TechnologyID> {

    Optional<List<TechnologyDAO>> findByIdPersonContaining(String idPerson);

    Optional<List<TechnologyDAO>> findByTechnologyContainingIgnoreCase(String technology);

}

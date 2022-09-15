package cl.programadoreschile.adrian.profilemaster.persistence.crud;

import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyDAO;
import cl.programadoreschile.adrian.profilemaster.persistence.models.TechnologyId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyCrudRepository extends CrudRepository<TechnologyDAO, TechnologyId> {
}

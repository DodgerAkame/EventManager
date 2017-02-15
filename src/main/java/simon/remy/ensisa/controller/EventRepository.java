package simon.remy.ensisa.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "event", path = "event")
public interface EventRepository extends CrudRepository<Event, Integer>{

	List<Event> findByTitle(String title);
}

package simon.remy.ensisa.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class EventDAOImpl implements EventDAO {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Bean  
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf){  
	    return hemf.getSessionFactory();  
	} 
	
	private Session getCurrentSession(){
		return sessionfactory.getCurrentSession();
	}
	
	@Override
	public void addEvent(Event e) {
		getCurrentSession().save(e);
	}

	@Override
	public void updateEvent(Event e) {
		Event eventToUpdate = getEvent(e.getId());
		eventToUpdate.setDate(e.getDate());
		eventToUpdate.setDescription(e.getDescription());
		eventToUpdate.setHours(e.getHours());
		eventToUpdate.setLieu(e.getLieu());
		eventToUpdate.setTitle(e.getTitle());
		eventToUpdate.setType(e.getType());
		getCurrentSession().update(eventToUpdate);
		
	}

	@Override
	public Event getEvent(int id) {
		Event event = (Event) getCurrentSession().get(Event.class, id);
		return event;
	}

	@Override
	public void deleteEvent(int id) {
		Event event = (Event) getCurrentSession().get(Event.class, id);
		if(event != null) getCurrentSession().delete(event);
	}

	@Override
	public List<Event> getEvents() {
		return getCurrentSession().createQuery("from events").list();
	}

}

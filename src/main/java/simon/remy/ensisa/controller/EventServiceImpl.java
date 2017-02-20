package simon.remy.ensisa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAOImpl dao;
	
	@Override
	public void addEvent(Event e) {
		dao.addEvent(e);
	}

	@Override
	public void updateEvent( Event e) {
		dao.updateEvent(e);
	}

	@Override
	public Event getEvent(int id) {
		return dao.getEvent(id);
	}

	@Override
	public void deleteEvent(int id) {
		dao.deleteEvent(id);
		
	}

	@Override
	public List<Event> getEvents() {
		return dao.getEvents();
	}

}

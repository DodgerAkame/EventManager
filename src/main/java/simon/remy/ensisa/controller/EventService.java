package simon.remy.ensisa.controller;

import java.util.List;

public interface EventService {

	public void addEvent(Event e);
	public void updateEvent(Event e);
	public Event getEvent(int id);
	public void deleteEvent(int id);
	public List<Event> getEvents();

}

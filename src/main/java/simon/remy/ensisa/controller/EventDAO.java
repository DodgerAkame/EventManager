package simon.remy.ensisa.controller;

import java.util.List;

public interface EventDAO {

	public void addEvent(Event e);
	public void updateEvent( Event e);
	public Event getEvent(int id);
	public void deleteEvent(int id);
	public List<Event> getEvents();

}

package simon.remy.ensisa.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseLoader {

	@Autowired
	private EventService service;

	public DatabaseLoader(EventService service) {
		this.service = service;
	}

	@PostConstruct
	void init() {
		service.addEvent(new Event("2017-03-04", "Senyu",
				"Convention sur la culture japonaise se déroulant au parc des Expos à Epinal", 48, "Epinal",
				"Convention"));
		Event event = new Event("2017-07-14", "14 juillet", "Journée nationale", 24, "France", "Fête nationale");
		event.setFavorite(true);
		service.addEvent(event);
		Event event2 = new Event("2017-02-24", "Dernier délai pour projet Appli Web", "Deadline pour le projet d'appli Web", 24, "Mulhouse", "Dernier délai");
		service.addEvent(event2);
	}

}

package simon.remy.ensisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EventFavoriteController {

	@Autowired
	private EventService service;

	@GetMapping("/fave/{id}")
	public String faveEvent(@PathVariable int id) {

		Event event = service.getEvent(id);
		if (event.isFavorite()) {
			event.setFavorite(false);
		} else {
			event.setFavorite(true);
		}
		
		service.updateEvent(event);

		return "redirect:/liste";
	}

}

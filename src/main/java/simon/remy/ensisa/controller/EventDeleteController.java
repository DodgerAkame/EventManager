package simon.remy.ensisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EventDeleteController {
	
	@Autowired
	private EventService service;
	
	@GetMapping("/delete/{id}")
	@Transactional
	public String deleteEvent(@PathVariable int id){
		service.deleteEvent(id);
		return "redirect:/liste";
	}

}

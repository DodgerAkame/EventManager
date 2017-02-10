package simon.remy.ensisa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListEventController {

	@Autowired
	private EventService service;
	
	@GetMapping("/liste")
	public String eventList(Model model){
		model.addAttribute("events", service.getEvents());
		
		
		System.out.println(service.getEvents().size());
		
		return "liste";
	}
	
}

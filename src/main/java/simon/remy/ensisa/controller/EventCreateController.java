package simon.remy.ensisa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class EventCreateController extends WebMvcConfigurerAdapter {

	@Autowired
	private EventService service;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {

		service.addEvent(new Event("2017-02-18", "Event 1", "Description 1", 2, "Location 1", "Type 1"));
		service.addEvent(new Event("31/05/2017", "Event 2", "Description 2", 5, "Location 2", "Type 2"));
		service.addEvent(new Event("01/01/2017", "Event 3", "Description 3", 10, "Location 1", "Type 3"));
		service.addEvent(new Event("02/08/2017", "Event 2", "Description 4", 5, "Location 4", "Type 4"));
		service.addEvent(new Event("31/05/2017", "Event 4", "Description 2", 5, "Location 2", "Type 2"));

		registry.addViewController("/result").setViewName("result");
	}

	@GetMapping("/creation")
	public String eventForm(Model model) {
		model.addAttribute("event", new Event());
		return "creation";
	}

	@PostMapping("/creation")
	public String eventSubmit(@Valid Event event, BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return "creation";

		service.addEvent(event);

		return "result";
	}
}

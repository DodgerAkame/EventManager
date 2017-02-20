package simon.remy.ensisa.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import simon.remy.ensisa.Application;

@Controller
public class EditEventController extends WebMvcConfigurerAdapter {

	@Autowired
	private EventService service;

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private Integer id;
	

	@GetMapping("/edit/{id}")
	public String eventEdit(@PathVariable Integer id, Model model) {
		model.addAttribute("event", service.getEvent(id));
		this.id = id;
		return "edit";
	}

	@PostMapping("/edit")
	@Transactional
	public String eventEditPost(@Valid @ModelAttribute("event") Event event, BindingResult bindingResult, Model model) {

		// if (bindingResult.hasErrors()) {
		// System.out.println("HEY");
		// return "edit";
		// }

		if (bindingResult.hasErrors()) {
			log.info(null, bindingResult.getFieldErrorCount());
			return "edit/" + event.getId();
		}
		
		
		event.setId(id);
		service.updateEvent(event);
		

		return "redirect:/liste";
	}

}

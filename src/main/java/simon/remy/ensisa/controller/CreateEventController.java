package simon.remy.ensisa.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class CreateEventController extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
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

		return "result";
	}
}

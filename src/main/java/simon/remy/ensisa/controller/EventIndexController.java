package simon.remy.ensisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventIndexController {

	@GetMapping("/")
	public String indexShow(){
		return "index";
	}
	
}

package rest.api.spring.security.jwt.simple.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class View {

	@RequestMapping(value = "/view/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/view/persons")
	public String listPerson() {
		return "persons";
	}

	@RequestMapping(value = "/view/editPerson")
	public String editPerson(@RequestParam int id, Model model) {
		model.addAttribute("id", id);
		return "editPerson";
	}
	
	@RequestMapping(value = "/view/addPerson")
	public String addPerson() {
		return "addPerson";
	}
}

package springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

	@RequestMapping("loginForm")
	public String loginForm() {
		return "login";
	}
	@RequestMapping("/")
	public String index() {
		return "listPerson";
	}

	@RequestMapping("/editPerson")
	public String editPerson(@RequestParam("id") int id, Model model) {
		model.addAttribute("personID", id);
		return "editPerson";
	}

	@RequestMapping("/addPerson")
	public String addPerson() {
		return "addPerson";
	}

	@RequestMapping("/listCareers")
	public String listCareers() {
		return "listCarees";
	}
}

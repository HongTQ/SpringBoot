package rest.api.spring.security.jwt.simple.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View {
	
	@RequestMapping(value = "/view/login")
	public String login() {
		return "login";
	}
	
}

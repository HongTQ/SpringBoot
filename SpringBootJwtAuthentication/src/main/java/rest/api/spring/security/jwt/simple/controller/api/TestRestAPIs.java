package rest.api.spring.security.jwt.simple.controller.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPIs {

	@GetMapping("/api/test/view")
	@PreAuthorize("hasRole('VIEW') or hasRole('ADMIN') or hasRole('USER')")
	public String projectManagementAccess() {
		return ">>> view contents";
	}

	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
}

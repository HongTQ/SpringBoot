package simple.security.boot.spring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import simple.security.boot.spring.app.dto.UserProfileDto;
import simple.security.boot.spring.app.service.UserProfileService;

@RestController
@RequestMapping(value = "/api/userprofiles")
public class UserProfileController {
	
	@Autowired
	private UserProfileService userProfileService;
	
	@GetMapping(value = "")
	public ResponseEntity<List<UserProfileDto>> getAllCareers() {
		return new ResponseEntity<List<UserProfileDto>>(userProfileService.findListUserProfileDto(), HttpStatus.OK);
	}
}

package springboot.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.demo.entity.Account;
import springboot.demo.service.AccountService;
import springboot.demo.service.JwtService;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	private JwtService jwtService;

	@Autowired
	private AccountService accountService;

	@PostMapping(value = "")
	public ResponseEntity<String> login(@Valid @RequestBody Account account) {
		String result = "";
		HttpStatus httpStatus = null;
		try {
			if (accountService.checkLogin(account)) {
				result = jwtService.generateTokenLogin(account.getAccountName());
				httpStatus = HttpStatus.OK;
			} else {
				result = "Wrong Account Name or Password";
				httpStatus = HttpStatus.BAD_REQUEST;
			}
		} catch (Exception e) {
			result = "Server Fail";
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(result, httpStatus);
	}
}

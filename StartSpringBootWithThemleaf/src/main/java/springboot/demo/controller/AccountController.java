package springboot.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.demo.entity.Account;
import springboot.demo.service.AccountService;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping(value = { "", "/" })
	public ResponseEntity<List<Account>> findAllAcount() {
		return new ResponseEntity<List<Account>>(accountService.findAll(), HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Account> addAccount(@Valid @RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.addAccount(account), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable("id") int id, @Valid @RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.updateAccount(id, account), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAcountById(@PathVariable("id") int id) {
		return ResponseEntity.ok().build();
	}
}

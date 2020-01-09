package rest.api.spring.security.jwt.simple.controller.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.api.spring.security.jwt.simple.model.Person;
import rest.api.spring.security.jwt.simple.service.PersonService;

@RestController
@RequestMapping(value = "/api/persons")
public class PersonController {
	@Autowired
	private PersonService personService;

	@GetMapping(value = "/page/{page}/size/{size}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER') or hasRole('VIEW')")
	public ResponseEntity<Page<Person>> paginationPersons(@PathVariable("page") int page,
			@PathVariable("size") int size) {
		return new ResponseEntity<Page<Person>>(personService.paginationPersons(page, size), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") int id, @Valid @RequestBody Person person) {
		return new ResponseEntity<Person>(personService.editPerson(id, person), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable("id") int id) {
		personService.deletePerson(id);
		return ResponseEntity.ok().build();
	}
}

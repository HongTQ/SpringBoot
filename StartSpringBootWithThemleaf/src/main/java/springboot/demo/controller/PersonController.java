package springboot.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import springboot.demo.entity.Person;
import springboot.demo.service.PersonService;

@RestController
@RequestMapping(value = "/api/persons")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("")
	public ResponseEntity<Page<Person>> getAllPerson() {
		return new ResponseEntity<Page<Person>>(personService.getAllPerson(), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
		return new ResponseEntity<Person>(personService.addPerson(person), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Person>> findPersonById(@PathVariable("id") int personID) {
		return new ResponseEntity<Optional<Person>>(personService.findPersonById(personID), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") int personID, @Valid @RequestBody Person person) {
		return new ResponseEntity<Person>(personService.editPerson(personID, person), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable("id") int personID) {
		personService.deletePerson(personID);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/page/{page}/size/{size}")
	public ResponseEntity<Page<Person>> creatPageAble(@PathVariable("page") int page, @PathVariable("size") int size) {
		return new ResponseEntity<Page<Person>>(personService.paginationPersons(page, size), HttpStatus.OK);
	}

	@GetMapping(value = "/sorts/{fieldName}")
	public ResponseEntity<Page<Person>> sortAllPersons(@PathVariable("fieldName") String fieldName) {
		Page<Person> persons = personService.sortAllPersons(fieldName);
		return new ResponseEntity<Page<Person>>(persons, HttpStatus.OK);
	}
	
	@GetMapping(value = "/search/{strSearch}")
	public ResponseEntity<List<Person>> searchAllPersons(@PathVariable("strSearch") String strSearch) {
		if(strSearch!=null) strSearch = strSearch.trim();
		List<Person> persons = personService.searchAllPersons(strSearch);
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

}

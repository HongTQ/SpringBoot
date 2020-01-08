package springboot.demo.controller;

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

import springboot.demo.entity.Career;
import springboot.demo.service.CareerService;

@RestController
@RequestMapping(value = "/api/careers")
public class CareerController {
	
	@Autowired
	private CareerService careerService;
	
	@GetMapping(value = "")
	public ResponseEntity<Page<Career>> getAllCareers(){
		return new ResponseEntity<Page<Career>>(careerService.getAllCareer(),HttpStatus.OK);
	}

	@PostMapping(value = "")
	public ResponseEntity<Career> addPerson(@Valid @RequestBody Career career) {
		return new ResponseEntity<Career>(careerService.addCareer(career), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Career> updateCareer(@PathVariable("id") int id, @Valid @RequestBody Career career) {
		return new ResponseEntity<Career>(careerService.editCareer(id, career),HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delCareer(@PathVariable("id") int id){
		careerService.deleteCareer(id);
		return ResponseEntity.ok().build();
	}
}

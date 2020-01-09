package rest.api.spring.security.jwt.simple.service;

import org.springframework.data.domain.Page;

import rest.api.spring.security.jwt.simple.model.Person;


public interface PersonService {
	Page<Person> paginationPersons(int page, int size);
	void deletePerson(int id);
	Person editPerson(int id,Person person);
}

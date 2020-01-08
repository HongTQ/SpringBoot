package springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import springboot.demo.entity.Person;

public interface PersonService {
	Page<Person> getAllPerson();
	void deletePerson(int id);
	Person editPerson(int id,Person person);
	Person addPerson(Person person);
	Optional<Person> findPersonById(int id);
	Page<Person> sortAllPersons(String strSearch);
	List<Person> searchAllPersons(String strSearch);
	Page<Person> paginationPersons(int page, int size);
}

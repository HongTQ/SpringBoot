package rest.api.spring.security.jwt.simple.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import rest.api.spring.security.jwt.simple.model.Person;
import rest.api.spring.security.jwt.simple.repository.PersonRepository;
import rest.api.spring.security.jwt.simple.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Page<Person> paginationPersons(int page, int size) {
		Page<Person> persons = personRepository.findAll(PageRequest.of(page, size));
		return persons;
	}

	@Override
	public void deletePerson(int id) {
		personRepository.deleteById(id);
	}

	@Override
	public Person editPerson(int id, Person person) {
		Optional<Person> personFindById = personRepository.findById(id);
		if (!personFindById.isPresent()) {
			return null;
		} else {
			Person personUpdate = personFindById.get();
			personUpdate.setAddress(person.getAddress());
			personUpdate.setBirthday(person.getBirthday());
			personUpdate.setEmail(person.getEmail());
			personUpdate.setName(person.getEmail());
			personUpdate.setPhone(person.getPhone());
			return personRepository.save(personUpdate);
		}
	}

}

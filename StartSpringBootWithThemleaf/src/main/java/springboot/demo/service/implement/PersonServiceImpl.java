package springboot.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import springboot.demo.common.exception.NotFoundException;
import springboot.demo.entity.Person;
import springboot.demo.repository.PersonRepository;
import springboot.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Page<Person> getAllPerson() {
		Page<Person> persons = personRepository.findAll(PageRequest.of(0, 5));
		return persons;
	}

	@Override
	public Person editPerson(int id, Person person) {
		Optional<Person> new_person = personRepository.findById(id);
		if (!new_person.isPresent()) {
			throw new NotFoundException("Not found id = " + id + " ");
		}
		Person getPerson = new_person.get();
		getPerson.setSex(person.isSex());
		getPerson.setAddress(person.getAddress());
		getPerson.setBirthday(person.getBirthday());
		getPerson.setFirstName(person.getFirstName());
		getPerson.setLastName(person.getLastName());
		getPerson.setPhone(person.getPhone());
		getPerson.setCareers(person.getCareers());
		return personRepository.save(getPerson);

	}

	@Override
	public Person addPerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deletePerson(int id) {
		Optional<Person> new_person = personRepository.findById(id);
		if (!new_person.isPresent()) {
			throw new NotFoundException("Not found id = " + id + " ");
		}
		personRepository.deleteById(id);
	}

	@Override
	public Optional<Person> findPersonById(int id) {
		return personRepository.findById(id);
	}

	@Override
	public Page<Person> sortAllPersons(String strSearch) {
		Page<Person> persons = personRepository.findAll(PageRequest.of(0,5,Sort.by(Sort.Direction.DESC, strSearch)));
		return persons;
	}

	@Override
	public List<Person> searchAllPersons(String strSearch) {
		List<Person> persons = (List<Person>) personRepository.findByLastname(strSearch);
		return persons;
	}

	@Override
	public Page<Person> paginationPersons(int page, int size) {
		if (size < 5 || page < 0) {
			throw new NotFoundException("The page must be greater than 0 and the size must be greater than 5");
		} else {
			Page<Person> persons = personRepository.findAll(PageRequest.of(page, size));
			return persons;
		}
	}
}

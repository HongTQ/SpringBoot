package springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springboot.demo.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	@Query(value = "SELECT * FROM quanlynhansu.persons where first_name like %?1% ", nativeQuery = true)
	List<Person> findByLastname(String strSearch);
}

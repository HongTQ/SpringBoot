package rest.api.spring.security.jwt.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.api.spring.security.jwt.simple.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}

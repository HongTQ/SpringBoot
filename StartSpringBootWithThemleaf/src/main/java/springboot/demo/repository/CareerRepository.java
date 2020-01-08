package springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.demo.entity.Career;

public interface CareerRepository extends JpaRepository<Career, Integer> {
	
}

package springboot.demo.service;

import org.springframework.data.domain.Page;

import springboot.demo.entity.Career;

public interface CareerService {
	Page<Career> getAllCareer();
	void deleteCareer(int id);
	Career addCareer(Career career);
	Career editCareer(int id,Career career);
}

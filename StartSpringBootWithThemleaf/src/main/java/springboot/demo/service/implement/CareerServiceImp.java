package springboot.demo.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import springboot.demo.common.exception.NotFoundException;
import springboot.demo.entity.Career;
import springboot.demo.repository.CareerRepository;
import springboot.demo.service.CareerService;

@Service
public class CareerServiceImp implements CareerService {

	@Autowired
	private CareerRepository careerRepository;

	@Override
	public Page<Career> getAllCareer() {
		return careerRepository.findAll(PageRequest.of(0, 10));
	}

	@Override
	public void deleteCareer(int id) {
		Optional<Career> findCareer = careerRepository.findById(id);
		if (!findCareer.isPresent()) {
			throw new NotFoundException("Not found id = " + id + " ");
		}
		careerRepository.deleteById(id);
	}

	@Override
	public Career addCareer(Career career) {
		return careerRepository.save(career);
	}

	@Override
	public Career editCareer(int id, Career career) {
		Optional<Career> findCareer = careerRepository.findById(id);
		if (!findCareer.isPresent()) {
			throw new NotFoundException("Not found id = " + id + " ");
		}
		Career editCareer = findCareer.get();
		editCareer.setNameCareer(career.getNameCareer());
		return careerRepository.save(editCareer);
	}

}

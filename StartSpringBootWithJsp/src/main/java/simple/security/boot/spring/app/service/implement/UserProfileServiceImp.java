package simple.security.boot.spring.app.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import simple.security.boot.spring.app.dto.UserProfileDto;
import simple.security.boot.spring.app.entity.UserProfile;
import simple.security.boot.spring.app.repository.UserProfileRepository;
import simple.security.boot.spring.app.service.UserProfileService;

@Service
public class UserProfileServiceImp implements UserProfileService {
	@Autowired
	private UserProfileRepository userProfileRepository;

	@Override
	public void deleteUserProfile(int id) {
		userProfileRepository.deleteById(id);
	}

	@Override
	public Optional<UserProfile> finUserProfileById(int id) {
		return userProfileRepository.findById(id);
	}

	@Override
	public List<UserProfileDto> findListUserProfileDto() {
		return userProfileRepository.findListUserProfileDto();
	}
}

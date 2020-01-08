package simple.security.boot.spring.app.service;

import java.util.List;
import java.util.Optional;

import simple.security.boot.spring.app.dto.UserProfileDto;
import simple.security.boot.spring.app.entity.UserProfile;

public interface UserProfileService {
	Optional<UserProfile> finUserProfileById(int id);
	void deleteUserProfile(int id);
	List<UserProfileDto> findListUserProfileDto();
}

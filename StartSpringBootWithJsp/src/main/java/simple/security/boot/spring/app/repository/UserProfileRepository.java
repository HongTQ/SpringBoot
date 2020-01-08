package simple.security.boot.spring.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import simple.security.boot.spring.app.dto.UserProfileDto;
import simple.security.boot.spring.app.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>{
	@Query(value = "SELECT user_profile.id,user_profile.name,user_profile.phone,user_profile.gmail,user_profile.address,user_profile.birthday,user.user_name FROM quanlynhansu2.user_profile INNER JOIN user ON user_profile.id_user = user.id",nativeQuery = true)
	List<UserProfileDto> findListUserProfileDto();
}

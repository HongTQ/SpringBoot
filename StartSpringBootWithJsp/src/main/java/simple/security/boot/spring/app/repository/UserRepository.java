package simple.security.boot.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import simple.security.boot.spring.app.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String userName);
//	User findUserByUserNameAndPassword(String userName, String password);
}

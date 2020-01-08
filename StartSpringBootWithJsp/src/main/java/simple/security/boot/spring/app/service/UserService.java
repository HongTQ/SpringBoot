package simple.security.boot.spring.app.service;

import simple.security.boot.spring.app.entity.User;

public interface UserService {
	void save(User user);
	User findByUserName(String userName);
//	boolean checkLogin(User user);
}

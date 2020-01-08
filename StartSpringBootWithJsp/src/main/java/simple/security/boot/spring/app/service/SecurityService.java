package simple.security.boot.spring.app.service;

import org.springframework.stereotype.Repository;

@Repository
public interface SecurityService {
	/**
	 * Find user name logged in
	 * @return user name logged in
	 */
	String findLoggedInUsername();

	/**
	 * Auto login
	 * @param userName
	 * @param password
	 */
	void autoLogin(String userName, String password);
}

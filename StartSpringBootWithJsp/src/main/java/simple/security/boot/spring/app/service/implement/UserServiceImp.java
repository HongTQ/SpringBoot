package simple.security.boot.spring.app.service.implement;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import simple.security.boot.spring.app.entity.User;
import simple.security.boot.spring.app.repository.RoleRepository;
import simple.security.boot.spring.app.repository.UserRepository;
import simple.security.boot.spring.app.service.UserService;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		userRepository.save(user);
	}

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

//	@Override
//	public boolean checkLogin(User user) {
//		User userCheck = userRepository.findUserByUserNameAndPassword(user.getUserName(), user.getPasswordConfirm());
//		if(userCheck != null) {
//			return false;
//		}else {
//			return true;
//		}
//	}
	
}

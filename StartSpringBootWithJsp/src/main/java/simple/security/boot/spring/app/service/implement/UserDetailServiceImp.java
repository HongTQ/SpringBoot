package simple.security.boot.spring.app.service.implement;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import simple.security.boot.spring.app.entity.Role;
import simple.security.boot.spring.app.entity.User;
import simple.security.boot.spring.app.repository.UserRepository;

@Service
public class UserDetailServiceImp implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	/**
	 *	set user name in GrantedAuthority use User Class of Security
	 */
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				grantedAuthorities);
	}

}

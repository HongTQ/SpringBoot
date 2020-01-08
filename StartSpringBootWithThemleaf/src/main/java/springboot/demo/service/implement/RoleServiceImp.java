package springboot.demo.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import springboot.demo.entity.Role;
import springboot.demo.repository.RoleRepository;
import springboot.demo.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<Role> roles = new ArrayList<Role>();
		roleRepository.findAll().forEach(role -> {
			roles.add(role);
		});
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getNameRole()));
		}
		return authorities;
	}

}

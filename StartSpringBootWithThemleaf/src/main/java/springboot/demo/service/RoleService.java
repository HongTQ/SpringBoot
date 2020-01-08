package springboot.demo.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public interface RoleService {
	public List<GrantedAuthority> getAuthorities();
}

package rest.api.spring.security.jwt.simple.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rest.api.spring.security.jwt.simple.model.Role;
import rest.api.spring.security.jwt.simple.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByName(RoleName roleName);
}

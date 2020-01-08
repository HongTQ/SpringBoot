package simple.security.boot.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import simple.security.boot.spring.app.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}

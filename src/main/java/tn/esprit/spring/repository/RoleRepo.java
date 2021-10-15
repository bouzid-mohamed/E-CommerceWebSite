package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.model.Role;



public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findbyname(String name);

}

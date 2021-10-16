package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.model.User;
import tn.esprit.spring.model.Role;


public interface UserService {
	User SaveUser(User user);
	Role SaveRole(Role role);
	Optional<User> GetUser(Long id);
	void AddRoleToUser(Long id ,Long idr) ;
	List<User> GetUsers();
	void DeleteUser(Long id) ;
	User UpdateUser(User user , Optional<User> useru);
	
}

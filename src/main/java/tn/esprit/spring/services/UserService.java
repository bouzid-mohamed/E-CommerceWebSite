package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.model.User;
import tn.esprit.spring.model.Role;


public interface UserService {
	User SaveUser(User user);
	Role SaveRole(Role role);
	void AddRoleToUser(String email ,String rolename) ;
	User GetUserbyEmail(String email) ;
	List<User> GetUsers();
	void DeleteUser(Long id) ;
	
}

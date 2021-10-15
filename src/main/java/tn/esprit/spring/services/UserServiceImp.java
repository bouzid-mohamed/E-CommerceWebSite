package tn.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Role;
import tn.esprit.spring.model.User;
import tn.esprit.spring.repository.RoleRepo;
import tn.esprit.spring.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserRepo userRepo ;
	@Autowired
	RoleRepo rolerepo ;
	
	public User SaveUser(User user) {
		return userRepo.save(user);
	}

	public Role SaveRole(Role role) {
		return rolerepo.save(role);
	}

	public void AddRoleToUser(String email, String rolename) {
		User user = userRepo.findbyemail(email);
		Role role = rolerepo.findbyname(rolename);
		user.getRoles().add(role);	
	}

	public User GetUserbyEmail(String email) {
		return userRepo.findbyemail(email);
	}

	public List<User> GetUsers() {
		return userRepo.findAll() ;
				}
	 public void DeleteUser(Long id) {
		 userRepo.deleteById(id);
	    }
	 public User updateUser(User user) {
	        userRepo.findById(user.getId());
	        return this.SaveUser(user);
	    }

}

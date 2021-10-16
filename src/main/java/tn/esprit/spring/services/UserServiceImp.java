package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.model.Category;
import tn.esprit.spring.model.Role;
import tn.esprit.spring.model.User;
import tn.esprit.spring.repository.RoleRepo;
import tn.esprit.spring.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
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

	public Optional<User> GetUser(Long id) {
		return userRepo.findById(id);
	}
	public void AddRoleToUser(Long id, Long idr) {
		Optional<User> user = userRepo.findById(id);
		Optional<Role> role = rolerepo.findById(idr);
		List<Role> roles = new ArrayList<>();
		roles.add(role.get());
		if (user.isPresent()) {
		user.get().setRoles(roles);	
		}
	}
	public User UpdateUser(User user,Optional<User> user9dim) {
			User user9dimm = user9dim.get();
			if(user.getEmail() != null && !user.getEmail().isEmpty())
				user9dimm.setEmail(user.getEmail());
			if(user.getFirstname() != null && !user.getFirstname().isEmpty())
				user9dimm.setFirstname(user.getFirstname());
			if(user.getAvatar() != null && !user.getAvatar().isEmpty())
				user9dimm.setAvatar(user.getAvatar());
			if(user.getLastname() != null && !user.getLastname().isEmpty())
				user9dimm.setLastname(user.getLastname());
			if(user.getPassword() != null && !user.getPassword().isEmpty())
				user9dimm.setPassword(user.getPassword());
			return user ;
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

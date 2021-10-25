package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@Transactional
public class UserServiceImp implements UserService , UserDetailsService {
	@Autowired
	UserRepo userRepo ;
	@Autowired
	RoleRepo rolerepo ;
	
	public User SaveUser(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		System.out.println(user.getPassword());
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
			if(user.getUsername() != null && !user.getUsername().isEmpty())
				user9dimm.setUsername(user.getUsername());
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Username :" + username);
		User user = userRepo.findByUsername(username).get();
		System.out.println("user :" + user);
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
}

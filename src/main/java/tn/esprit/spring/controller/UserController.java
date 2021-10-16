package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.model.Category;
import tn.esprit.spring.model.Product;
import tn.esprit.spring.model.Role;
import tn.esprit.spring.model.User;
import tn.esprit.spring.services.UserService;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
	UserService userService ;
    
	@GetMapping("/all")
	public ResponseEntity<List<User>>getUsers(){
		return ResponseEntity.ok().body(userService.GetUsers()) ;
	}
	
	@GetMapping("/show/{id}")
	public ResponseEntity<User> show(@PathVariable("id") Long id) {
		Optional<User> user = userService.GetUser(id);

		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> add(@RequestBody User user) {
		try {
			User userr = userService.SaveUser(user);
			return new ResponseEntity<>(userr, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> user9dim = userService.GetUser(id);
		if (user9dim.isPresent()) {
		User useru = userService.UpdateUser(user,user9dim);
			return new ResponseEntity<>(userService.GetUser(id).get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
		try {
			userService.DeleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PostMapping("/addrole")
	public ResponseEntity<Role> addrole(@RequestBody Role role) {
		try {
			Role userr = userService.SaveRole(role);
			return new ResponseEntity<>(userr, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value = "/addroleuser/{idu}/{idr}") 
	public ResponseEntity<User> Addroletouser(@PathVariable("idu")Long idu, @PathVariable("idr")Long idr)
	{
		userService.AddRoleToUser(idu, idr);
		return ResponseEntity.ok().build() ;
	}

}

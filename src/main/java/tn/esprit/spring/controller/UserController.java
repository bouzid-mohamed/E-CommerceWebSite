package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping("/{email}")
	public ResponseEntity<User> getUser(@PathVariable("email") String email){
		return ResponseEntity.ok().body(userService.GetUserbyEmail(email)) ;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		return ResponseEntity.ok().body("User deleted") ;
	}

}

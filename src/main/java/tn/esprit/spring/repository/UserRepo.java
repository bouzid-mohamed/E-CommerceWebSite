package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.spring.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	User findbyfirstname(String firstname);
	User findbyemail(String email);
	User findbylastname(String firstname);

}
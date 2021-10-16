package tn.esprit.spring;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import tn.esprit.spring.model.Role;
import tn.esprit.spring.model.User;
import tn.esprit.spring.services.UserService;

@SpringBootApplication
@EntityScan("tn.esprit.spring.model")
@EnableJpaRepositories("tn.esprit.spring.repository")
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}


}

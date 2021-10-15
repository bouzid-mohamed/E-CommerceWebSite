package tn.esprit.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


import tn.esprit.spring.model.Product;


@Repository

public interface ProductRepository extends JpaRepository<Product , Long> {
	 
	 
	
	

}

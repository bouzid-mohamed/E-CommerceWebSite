package tn.esprit.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


import tn.esprit.spring.model.Product;

public interface ProductRepository extends JpaRepository<Product , Long> {
	 
	 
	
	

}

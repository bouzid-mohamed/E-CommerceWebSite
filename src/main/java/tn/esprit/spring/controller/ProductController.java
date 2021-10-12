package tn.esprit.spring.controller;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.model.Product;

import tn.esprit.spring.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	  ProductRepository productRepository;
	
	 @GetMapping("/index")
	  public ResponseEntity<List<Product>> getAllTutorials() {
	    try {
	      List<Product> products = new ArrayList<Product>();
	        productRepository.findAll().forEach(products::add);
	  
	      
	      if (products.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(products, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PostMapping("/add")
	  public ResponseEntity<Product> createTutorial(@RequestBody Product product) {
	    try {
	      Product _product = productRepository
	      .save(new Product(product.getName(),product.getDescription(),product.getPrice(),product.getImage(),product.getCreatedAt(),product.getDeletedAt()));
	      return new ResponseEntity<>(_product, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PutMapping("/update/{id}")
	  public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
	    Optional<Product> productData = productRepository.findById(id);

	    if (productData.isPresent()) {
	      Product  _product = productData.get();
	      _product.setName(product.getName());
	      _product.setDescription(product.getDescription());
	      _product.setImage(product.getImage());
	      _product.setPrice(product.getPrice());
	      
	      return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
	    try {
	      productRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/show/{id}")
	  public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
	    Optional<Product> productData =productRepository.findById(id);

	    if (productData.isPresent()) {
	      return new ResponseEntity<>(productData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }




	  


}

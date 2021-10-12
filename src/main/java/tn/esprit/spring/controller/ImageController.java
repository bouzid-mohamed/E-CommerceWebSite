package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.model.Image;
import tn.esprit.spring.repository.ImageRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/images")
public class ImageController {
	
	@Autowired
	  ImageRepository imageRepository;
	
	 @GetMapping("/index")
	  public ResponseEntity<List<Image>> getAllTutorials() {
	    try {
	      List<Image> images = new ArrayList<Image>();
	        imageRepository.findAll().forEach(images::add);
	  
	      
	      if (images.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(images, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 @PostMapping("/add")
	  public ResponseEntity<Image> createTutorial(@RequestBody Image image) {
	    try {
	      Image _image =imageRepository
	      .save(new Image(image.getName(),image.getThumbmail()));
	      return new ResponseEntity<>(_image, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 @DeleteMapping("/delete/{id}")
	  public ResponseEntity<HttpStatus> deleteImage(@PathVariable("id") long id) {
	    try {
	      imageRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	  
	  

}

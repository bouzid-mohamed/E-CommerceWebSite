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
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.model.Category;
import tn.esprit.spring.model.SubCat;
import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.repository.SubCatRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/subcategory")
public class SubCatController {

	@Autowired
	SubCatRepository subCatRepository;
	@Autowired
	CategoryRepository categoryRepository;

	public Category getCategoryById(@PathVariable("id") long id) {
		Optional<Category> categoryData = categoryRepository.findById(id);

		if (categoryData.isPresent()) {
			return categoryData.get();
		} else {
			return null;
		}
	}

	@PostMapping("/add")
	public ResponseEntity<SubCat> add(@RequestBody SubCat subCat) {

		try {
			Category c = this.getCategoryById(subCat.getCategory().getId());
			SubCat _subcat = subCatRepository.save(new SubCat(subCat.getGender(), c));
			return new ResponseEntity<>(_subcat, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/index")
	public ResponseEntity<List<SubCat>> index() {
		try {
			List<SubCat> subcats = new ArrayList<SubCat>();
			subCatRepository.findAll().forEach(subcats::add);

			if (subcats.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(subcats, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			subCatRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<SubCat> update(@PathVariable("id") long id, @RequestBody SubCat subcat) {
		Optional<SubCat> subcatData = subCatRepository.findById(id);

		if (subcatData.isPresent()) {
			SubCat _subcat = subcatData.get();
			_subcat.setGender(subcat.getGender());
			Category c = this.getCategoryById(subcat.getCategory().getId());
			_subcat.setCategory(c);
			return new ResponseEntity<>(subCatRepository.save(_subcat), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<SubCat> getById(@PathVariable("id") long id) {
		Optional<SubCat> productData = subCatRepository.findById(id);

		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

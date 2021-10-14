package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.model.Product;
import tn.esprit.spring.model.SubCat;

public interface SubCatRepository extends JpaRepository<SubCat , Long> {

}

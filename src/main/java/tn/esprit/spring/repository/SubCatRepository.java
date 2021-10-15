package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.model.Product;
import tn.esprit.spring.model.SubCat;


@Repository

public interface SubCatRepository extends JpaRepository<SubCat , Long> {

}

package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.model.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {

}

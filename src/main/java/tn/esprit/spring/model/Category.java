package tn.esprit.spring.model;

import java.util.Set;

import javax.persistence.*;




@Entity
@Table(name = "Category")
public class Category {

	@Id

	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "photo")
	private String photo;

	public Category(long id, String name, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;

	}
	public Category(long id) {
		super();
		this.id = id;
	}
	public Category(String name, String photo) {
		super();
		this.name = name;
		this.photo = photo;

	}
	public Category() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", photo=" + photo + "]";
	}
		

	



	
	
}

package tn.esprit.spring.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private float price;
	@Column(name = "image")
	private int image;
	@Column(name = "createdAt")
	private Date createdAt;
	@Column(name = "deletedAt")
	private Date deletedAt; 
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public void setId(long id) {
		this.id = id;
	}


	
	public long getId() {
		return id;
	}

	public Product( String name, String description, float price, int image, Date createdAt, Date deletedAt) {
		super();
	
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
	}
	
	public Product() {
		
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", image="
				+ image + ", createdAt=" + createdAt + ", deletedAt=" + deletedAt + "]";
	}
	
	
	








}

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
	@Column(name = "createdAt")
	private Date createdAt;
	@Column(name = "deletedAt")
	private Date deletedAt;
	@ManyToOne(cascade = CascadeType.ALL)
	Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

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

	public Product(String name, String description, float price, Date createdAt, Date deletedAt, Category category) {
		super();

		this.name = name;
		this.description = description;
		this.price = price;

		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.category = category;
	}

	public Product(long id) {
		super();
		this.id = id;
	}

	public Product() {

	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ",createdAt=" + createdAt + ", deletedAt=" + deletedAt + "]";
	}

}

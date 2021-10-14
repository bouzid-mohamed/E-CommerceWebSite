package tn.esprit.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "thumbmail")
	private String thumbmail;
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	private String name;

	public Image(String thumbmail, String name, Product product) {
		super();
		this.thumbmail = thumbmail;
		this.name = name;
		this.product = product;
	}

	public Image(long id, String thumbmail, Product product, String name) {
		super();
		this.id = id;
		this.thumbmail = thumbmail;
		this.product = product;
		this.name = name;
	}

	public Image() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getThumbmail() {
		return thumbmail;
	}

	public void setThumbmail(String thumbmail) {
		this.thumbmail = thumbmail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", thumbmail=" + thumbmail + ", product=" + product + ", name=" + name + "]";
	}

}

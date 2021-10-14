package tn.esprit.spring.model;

import javax.persistence.*;

@Entity
@Table(name = "subCat")
public class SubCat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "gender")
	private String gender;
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;

	public SubCat(long id, String gender) {
		super();
		this.id = id;
		this.gender = gender;
	}

	public SubCat(long id) {
		super();
		this.id = id;
	}

	public SubCat(String gender, Category category) {
		super();
		this.gender = gender;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCat() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "SubCat [id=" + id + ", gender=" + gender + "]";
	}

}

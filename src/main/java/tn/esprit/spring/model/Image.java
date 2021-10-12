package tn.esprit.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "thumbmail")
	private String thumbmail;
	@Column(name = "name")
	private String name;
	public Image(String thumbmail, String name) {
		super();
		this.thumbmail = thumbmail;
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
		return "Image [id=" + id + ", thumbmail=" + thumbmail + ", name=" + name + "]";
	}
	
	
	
	

}

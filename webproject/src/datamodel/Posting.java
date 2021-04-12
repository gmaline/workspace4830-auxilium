package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "donation")
public class Posting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "quality")
	private String quality;

	@Column(name = "description")
	private String description;
	
	@Column(name = "type")
	private Boolean type;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	public Posting() {
	}

	public Posting(Integer id, String name, String quality, String description, Boolean type, User userId) {
		this.id = id;
		this.name = name;
		this.quality = quality;
		this.description = description;
		this.type = type;
		this.userId = userId;

	}

	public Posting(String name, String quality, String description, Boolean type, User userId) {
		this.name = name;
		this.quality = quality;
		this.description = description;
		this.type = type;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public User getUser() {
		return userId;
	}

	public void setUser(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Donation name: " + this.name + ", type: " + this.type + " quality: " + this.quality + ", description: " + this.description +
				" from User: " + this.userId;
	}
}
package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "canDonate")
	private Boolean canDonate;

	@Column(name = "canRequest")
	private Boolean canRequest;

	public Role() {
	}

	public Role(Integer id, String name, Boolean donate, Boolean request) {
		this.id = id;
		this.name = name;
		this.canDonate = donate;
		this.canRequest = request;
	}

	public Role(String name, Boolean donate, Boolean request) {
		this.name = name;
		this.canDonate = donate;
		this.canRequest = request;
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

	public Boolean getDonate() {
		return canDonate;
	}

	public void setDonate(Boolean donate) {
		this.canDonate = donate;
	}

	public Boolean getRequest() {
		return canRequest;
	}

	public void setRequest(Boolean request) {
		this.canRequest = request;
	}

	@Override
	public String toString() {
		return "Role: " + this.name + ", canDonate: " + (this.canDonate ? "Yes" : "No") + ", canRequest "
				+ (this.canRequest ? "Yes" : "No");
	}
}
package lk.inova.dao.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the login_table database table.
 * 
 */
@Entity
@Table(name="login_table")
@NamedQuery(name="LoginTable.findAll", query="SELECT l FROM LoginTable l")
public class LoginTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String password;

	private String username;

	public LoginTable() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
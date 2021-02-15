package entities;

import java.security.NoSuchAlgorithmException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="login")
	private String login;
	
	@Column(name="hashed_password")
	private String password;
	
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="pasazer_id")
	private Pasazer pasazer;

	@Column(name="email")
	private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public Pasazer getPasazer() {
		return pasazer;
	}

	public void setPasazer(Pasazer pasazer) {
		this.pasazer = pasazer;
	}
	
	public Boolean proceedPassword(String password)throws NoSuchAlgorithmException  {
		
		return BCrypt.checkpw(password, this.password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		
	}

	public User(String login, String password,String email, Pasazer pasazer) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.pasazer = pasazer;
	}
	
	
	
}

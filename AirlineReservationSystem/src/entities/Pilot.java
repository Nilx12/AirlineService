package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="pilot")
public class Pilot {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="in_service_since")
	private int inService;

	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(name="passangers_on_flight",
			joinColumns=@JoinColumn(name="pilot_id"),
			inverseJoinColumns=@JoinColumn(name="plane_id")
			)
	private List<Plane> planes;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getInService() {
		return inService;
	}

	public void setInService(int inService) {
		this.inService = inService;
	}
	
	public List<Plane> getPlanes() {
		return planes;
	}

	public void setPlanes(List<Plane> planes) {
		this.planes = planes;
	}

	public void addPlane(Plane plane) {
		if(planes == null) {
			planes = new ArrayList<Plane>();
		}
		planes.add(plane);
	}
	
	
	public Pilot() {
		
	}
	
	public Pilot(String firstName, String lastName, String email, int inService) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.inService = inService;
	}
}

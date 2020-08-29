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
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="airline")
public class Airline {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="base_airport_id")
	private Airport airport;

	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(name="planes_in_possesion",
			joinColumns=@JoinColumn(name="airline_id"),
			inverseJoinColumns=@JoinColumn(name="plane_id")
			)
	private List<Plane> planes;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
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
	
	public Airline() {

	}
	
	public Airline(String name, Airport airport) {
		this.name = name;
		this.airport = airport;
	}
	
	
	
	
}

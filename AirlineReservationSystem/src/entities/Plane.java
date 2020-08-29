package entities;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="plane")
public class Plane {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="capacity")
	private int capacity;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="model_id")
	private Model model;

	/* @ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(name="passangers_on_flight",
			joinColumns=@JoinColumn(name="plane_id"),
			inverseJoinColumns=@JoinColumn(name="pilot_id")
			)
	private List<Pilot> pilots; */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	/* public List<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}
	
	public void addPilot(Pilot pilot) {
		if(pilots == null) {
			pilots= new ArrayList<Pilot>();
		}
		pilots.add(pilot);
	} */
	
	public Plane() {
	}
	
	public Plane(int capacity, Model model) {
		this.capacity = capacity;
		this.model = model;
	}
	
	
}

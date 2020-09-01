package entities;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="flight")
public class Flight {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="TakeOfDate")
	private Date date;
	
	@Column(name="TakeOfTime")
	private LocalTime time;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="plane_id")
	private Plane plane;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="airline_id")
	private Airline airline;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="crew_id")
	private Crew crew;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="origin_airport_id")
	private Airport originAirport;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="desitiny_airport_id")
	private Airport desitinyAirport;

	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(name="operated_classes",
			joinColumns=@JoinColumn(name="flight_id"),
			inverseJoinColumns=@JoinColumn(name="class_id")
			)
	private List<Class> classes;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public Crew getCrew() {
		return crew;
	}

	public void setCrew(Crew crew) {
		this.crew = crew;
	}

	public Airport getOriginAirport() {
		return originAirport;
	}

	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}

	public Airport getDesitinyAirport() {
		return desitinyAirport;
	}

	public void setDesitinyAirport(Airport desitinyAirport) {
		this.desitinyAirport = desitinyAirport;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	public void addClass(Class klasa) {
		if(classes == null) {
			classes= new ArrayList<Class>();
		}
		classes.add(klasa);
	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Flight() {
		
	}

	
	public Flight(Plane plane, Airline airline, Crew crew, Airport originAirport, Airport desitinyAirport,Date date,LocalTime time) {
		this.plane = plane;
		this.airline = airline;
		this.crew = crew;
		this.originAirport = originAirport;
		this.desitinyAirport = desitinyAirport;
		this.date = date;
		this.time = time;

	}
	
}

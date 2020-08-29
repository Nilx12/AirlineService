package entities;

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
@Table(name="crew")
public class Crew {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="first_pilot_id")
	private Pilot firstPilot;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="second_pilot_id")
	private Pilot secondPilot;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="flight_attendant_id")
	private FlightAttendant flightAttendant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pilot getFirstPilot() {
		return firstPilot;
	}

	public void setFirstPilot(Pilot firstPilot) {
		this.firstPilot = firstPilot;
	}

	public Pilot getSecondPilot() {
		return secondPilot;
	}

	public void setSecondPilot(Pilot secondPilot) {
		this.secondPilot = secondPilot;
	}

	public FlightAttendant getFlightAttendant() {
		return flightAttendant;
	}

	public void setFlightAttendant(FlightAttendant flightAttendant) {
		this.flightAttendant = flightAttendant;
	}

	public Crew() {
		
	}
	
	public Crew(Pilot firstPilot, Pilot secondPilot, FlightAttendant flightAttendant) {
		this.firstPilot = firstPilot;
		this.secondPilot = secondPilot;
		this.flightAttendant = flightAttendant;
	}
	
	
}

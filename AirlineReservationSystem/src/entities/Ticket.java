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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="class_id")
	private Class fligthClass;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="discount_id")
	private Discount discount;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="price_id")
	private Price price;
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="status_id")
	private TicketStatus status;
	
	@Column(name="accepted")
	boolean accepted;
	
	@Column(name="email")
	private String email;
	
	@Column(name="price")
	private int priceVal;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(name="passangers_on_flight",
			joinColumns=@JoinColumn(name="ticket_id"),
			inverseJoinColumns=@JoinColumn(name="passanger_id")
			)
	private List<FlightPassenger> passangers;

	@ManyToMany(fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(name="flight_on_ticket",
			joinColumns=@JoinColumn(name="ticket_id"),
			inverseJoinColumns=@JoinColumn(name="flight_id")
			)
	private List<Flight> flights;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Class getFligthClass() {
		return fligthClass;
	}

	public void setFligthClass(Class fligthClass) {
		this.fligthClass = fligthClass;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public List<FlightPassenger> getPassangers() {
		return passangers;
	}

	public void setPassangers(List<FlightPassenger> passangers) {
		this.passangers = passangers;
	}

	public void addPassanger(FlightPassenger pasazer) {
		if(passangers == null) {
			passangers= new ArrayList<FlightPassenger>();
		}
		passangers.add(pasazer);
	}
	
	public List<Flight> getlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public void addFlight(Flight flight) {
		if(flights == null) {
			flights= new ArrayList<Flight>();
		}
		flights.add(flight);
	}
	
	public List<Flight> getFlights() {
		return flights;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPriceVal() {
		return priceVal;
	}

	public void setPriceVal(int priceVal) {
		this.priceVal = priceVal;
	}

	
	
	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	
	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public Ticket() {
		
	}
	
	public Ticket(Class fligthClass, Discount discount, Price price,String email, int priceVal,TicketStatus status) {
		this.fligthClass = fligthClass;
		this.discount = discount;
		this.price = price;
		this.email = email;
		this.priceVal = priceVal;
		this.status = status;
	}
	
	
}

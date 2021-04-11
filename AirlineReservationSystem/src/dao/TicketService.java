package dao;

import java.util.List;

import entities.Flight;
import entities.FlightPassenger;
import entities.Pasazer;
import entities.Ticket;

public interface TicketService {
	
	public  List<Ticket> getTickets();
	
	public void saveTicket(Ticket ticket);
	
	public Ticket getTicketById(int id);
	
	//public  List<Ticket> getTicketsByFlight(int id);
	
	public  List<Ticket> getTicketsByPassenger(int id);
	
	public List<Flight> gFlist();
	
	public void sFlist(int id);

	public List<FlightPassenger> gPlist();
	
	public void sPlist(int id);
	
	public  List<Ticket> getTicketsByEmail(String email);
	
	public void deleteTicket(int id);
}

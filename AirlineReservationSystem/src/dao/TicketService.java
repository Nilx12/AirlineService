package dao;

import java.util.List;

import entities.Flight;
import entities.Pasazer;
import entities.Ticket;

public interface TicketService {
	
	public  List<Ticket> getTickets();
	
	public void saveTicket(Ticket ticket);
	
	public Ticket getTicketById(int id);
	
	public  List<Ticket> getTicketsByFlight(int id);
	
	public List<Flight> gFlist();
	
	public void sFlist(int id);

	public List<Pasazer> gPlist();
	
	public void sPlist(int id);
	
	public void deleteTicket(int id);
}

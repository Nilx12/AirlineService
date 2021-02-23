package dao;

import java.util.List;

import entities.Ticket;

public interface TicketDAO {
	
	public  List<Ticket> getTickets();
	
	public void saveTicket(Ticket ticket);
	
	public Ticket getTicketById(int id);
	
	public  List<Ticket> getTicketsByFlight(int id);
	
	public  List<Ticket> getTicketsByPassenger(int id);
	
	public void deleteTicket(int id);
}

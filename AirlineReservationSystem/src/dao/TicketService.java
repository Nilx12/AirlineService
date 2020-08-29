package dao;

import java.util.List;

import entities.Ticket;

public interface TicketService {
	
	public  List<Ticket> getTickets();
	
	public void saveTicket(Ticket ticket);
	
	public Ticket getTicketById(int id);
	
	public  List<Ticket> getTicketsByFlight(int id);
	
	public void deleteTicket(int id);
}

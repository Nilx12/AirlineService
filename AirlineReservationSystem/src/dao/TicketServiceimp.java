package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Ticket;

@Service
public class TicketServiceimp implements TicketService {

	@Autowired
	TicketDAO ticketDAO;
	
	@Override
	@Transactional
	public List<Ticket> getTickets() {
		
		return ticketDAO.getTickets();
	}

	@Override
	@Transactional
	public void saveTicket(Ticket ticket) {
		ticketDAO.saveTicket(ticket);

	}

	@Override
	@Transactional
	public Ticket getTicketById(int id) {
		return ticketDAO.getTicketById(id);
	}

	@Override
	@Transactional
	public List<Ticket> getTicketsByFlight(int id) {
		return ticketDAO.getTicketsByFlight(id);
	}

	@Override
	@Transactional
	public void deleteTicket(int id) {
		ticketDAO.deleteTicket(id);

	}

}

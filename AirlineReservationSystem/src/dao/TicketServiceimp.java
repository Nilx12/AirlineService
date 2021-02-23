package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Class;
import entities.Flight;
import entities.Pasazer;
import entities.Ticket;

@Service
public class TicketServiceimp implements TicketService {

	@Autowired
	TicketDAO ticketDAO;

	List<Flight> flist;
	
	List<Pasazer> plist;
	
	@Override
	@Transactional
	public void sFlist(int id) {
		if(flist == null) {
			flist = new ArrayList<Flight>();
		}else {
			flist.clear();
		}
		Ticket ticket = getTicketById(id);
		for(Flight flight:ticket.getlights() ) {
			flist.add(flight);
		}
	}
	
	@Override
	public List<Flight> gFlist(){
		return flist;
		
	}
	
	@Override
	@Transactional
	public void sPlist(int id) {
		if(plist == null) {
			plist = new ArrayList<Pasazer>();
		}else {
			flist.clear();
		}
		Ticket ticket = getTicketById(id);
		for(Pasazer pas:ticket.getPassangers() ) {
			plist.add(pas);
		}
	}
	
	@Override
	public List<Pasazer> gPlist(){
		
		
		return plist;
		
	}
	
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
	public List<Ticket> getTicketsByPassenger(int id) {
		return ticketDAO.getTicketsByPassenger(id);
	}

	
	@Override
	@Transactional
	public void deleteTicket(int id) {
		ticketDAO.deleteTicket(id);

	}

}

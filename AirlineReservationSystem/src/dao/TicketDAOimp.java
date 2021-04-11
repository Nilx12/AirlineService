package dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Model;
import entities.Ticket;
@Repository
public class TicketDAOimp implements TicketDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Ticket> getTickets() {
		Session session = sessionFactory.getCurrentSession();
		List<Ticket> tickets;
		try {
			
			Query<Ticket> query = session.createQuery("from Ticket",Ticket.class);
			
			tickets = query.getResultList();
			
		}catch(Exception e){
			
			tickets = null;
			
			e.printStackTrace();
		}
		return tickets;
	}

	@Override
	public List<Ticket> getTicketsByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		List<Ticket> tickets;
		try {
			
			Query<Ticket> query = session.createQuery("from Ticket where email=:email",Ticket.class);
			query.setParameter("email", email);
			tickets = query.getResultList();
			
		}catch(Exception e){
			
			tickets = null;
			
			e.printStackTrace();
		}
		return tickets;
	}
	
	@Override
	public void saveTicket(Ticket ticket) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(ticket);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public Ticket getTicketById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Ticket ticket;
		try {
			ticket = session.get(Ticket.class, id);
		}catch(Exception e){
			e.printStackTrace();
			ticket = null;
		}
		return ticket;
	}
	
	@Override
	public  List<Ticket> getTicketsByPassenger(int id){
		Session session = sessionFactory.getCurrentSession();
		List<Ticket> tickets;
		try {
			//Query<Ticket> query = session.createQuery("SELECT Ticket FROM Ticket INNER JOIN airline_reservation_system.passangers_on_flight ON Ticket.id = passangers_on_flight.ticket_id where passangers_on_flight.passanger_id=:fid",Ticket.class);
			SQLQuery<Ticket> query = session.createSQLQuery("SELECT ticket.* FROM airline_reservation_system.ticket INNER JOIN airline_reservation_system.passangers_on_flight ON ticket.id = passangers_on_flight.ticket_id where passangers_on_flight.passanger_id=:pid");
			query.setParameter("pid", id);
			query.addEntity(Ticket.class);
			tickets = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			tickets = null;
		}
		return tickets;
		
		
	}

	/*
	 * @Override public List<Ticket> getTicketsByFlight(int id){ Session session =
	 * sessionFactory.getCurrentSession(); List<Ticket> tickets; try { Query<Ticket>
	 * query = session.createQuery("from Ticket where flight_id=:pid",Ticket.class);
	 * query.setParameter("fid", id); tickets = query.getResultList();
	 * }catch(Exception e){ e.printStackTrace(); tickets = null; } return tickets;
	 * 
	 * 
	 * }
	 */
	@Override
	public void deleteTicket(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Ticket ticket = session.get(Ticket.class, id);
			
			session.delete(ticket);
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}

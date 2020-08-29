package dao;

import java.util.List;

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
		}finally {
			session.close();
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
		}finally {
			session.close();
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
		}finally {
			session.close();
		}
		return ticket;
	}

	@Override
	public  List<Ticket> getTicketsByFlight(int id){
		Session session = sessionFactory.getCurrentSession();
		List<Ticket> tickets;
		try {
			Query<Ticket> query = session.createQuery("from Ticket where flight_id=:fid",Ticket.class);
			query.setParameter("fid", id);
			tickets = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			tickets = null;
		}finally {
			session.close();
		}
		return tickets;
		
		
	}
	@Override
	public void deleteTicket(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Ticket ticket = session.get(Ticket.class, id);
			
			session.delete(ticket);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

}

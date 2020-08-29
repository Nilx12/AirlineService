package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import entities.Flight;
import entities.User;

@Repository
public class FlightDAOimp implements FlightDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Flight> getFlights() {
		Session session = sessionFactory.getCurrentSession();
		List<Flight> flight;
		try {
			
			Query<Flight> query = session.createQuery("from Flight",Flight.class);
			
			flight = query.getResultList();
			
		}catch(Exception e){
			
			flight = null;
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return flight;
	}

	@Override
	public void saveCrew(Flight flight) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(flight);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

	@Override
	public Flight getFlightById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Flight flight;
		try {
			flight = session.get(Flight.class, id);
		}catch(Exception e){
			e.printStackTrace();
			flight = null;
		}finally {
			session.close();
		}
		return flight;
	}

	@Override
	public void deleteFlight(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Flight flight = session.get(Flight.class, id);
			
			session.delete(flight);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

	@Override
	public Flight getFlightByOriginAirport(int id) {
		Session session = sessionFactory.getCurrentSession();
		Flight flight;
		try {
			Query<Flight> query = session.createQuery("from Flight where origin_airport_id=:fid",Flight.class);
			query.setParameter("fid", id);
			flight = query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			flight = null;
		}finally {
			session.close();
		}
		return flight;
	}

	@Override
	public Flight getFlightByDesitinyAirport(int id) {
		Session session = sessionFactory.getCurrentSession();
		Flight flight;
		try {
			Query<Flight> query = session.createQuery("from Flight where desitiny_airport_id=:fid",Flight.class);
			query.setParameter("fid", id);
			flight = query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			flight = null;
		}finally {
			session.close();
		}
		return flight;
	}

	@Override
	public Flight getFlightByAirline(int id) {
		Session session = sessionFactory.getCurrentSession();
		Flight flight;
		try {
			Query<Flight> query = session.createQuery("from Flight where airline_id=:fid",Flight.class);
			query.setParameter("fid", id);
			flight = query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			flight = null;
		}finally {
			session.close();
		}
		return flight;
	}

}

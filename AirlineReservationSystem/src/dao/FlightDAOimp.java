package dao;

import java.sql.Date;
import java.sql.Timestamp;
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
	public List<Flight> getFlights(Date date) {
		Session session = sessionFactory.getCurrentSession();
		List<Flight> flight;
		try {
			Query<Flight> query = session.createQuery("from Flight where TakeOfDate = :data",Flight.class);
			query.setParameter("data",date);
			flight = query.getResultList();
			
		}catch(Exception e){
			
			flight = null;
			
			e.printStackTrace();
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
		}

	}

	@Override
	public Flight getFlightByOriginAirport(int id,Date date) {
		Session session = sessionFactory.getCurrentSession();
		Flight flight;
		try {
			Query<Flight> query = session.createQuery("from Flight where origin_airport_id=:fid and TakeOfDate = :data",Flight.class);
			query.setParameter("data",date);
			query.setParameter("fid", id);
			flight = query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			flight = null;
		}
		return flight;
	}

	@Override
	public List<Flight> getFlightByDesitinyAndOriginAirport(int originId,int desitnityid,Date date) {
		Session session = sessionFactory.getCurrentSession();
		List<Flight> flights;
		try {
			Query<Flight> query = session.createQuery("from Flight where origin_airport_id=:oid and desitiny_airport_id=:did and TakeOfDate = :data",Flight.class);
			query.setParameter("data",date);
			query.setParameter("oid", originId);
			query.setParameter("did", desitnityid);
			flights = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			flights = null;
		}
		return flights;
	}
	
	@Override
	public List<Flight> getFlightByDesitinyAndOriginAirport(List<Integer> originId,List<Integer> desitnityid,Date date) {
		Session session = sessionFactory.getCurrentSession();
		List<Flight> flights;
		try {
			Query<Flight> query = session.createQuery("from Flight where origin_airport_id IN :oid and desitiny_airport_id IN :did and TakeOfDate = :data",Flight.class);
			query.setParameter("data",date);
			query.setParameter("oid", originId);
			query.setParameter("did", desitnityid);
			flights = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			flights = null;
		}
		return flights;
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
		}
		return flight;
	}

}

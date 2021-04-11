package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.FlightPassenger;
import entities.Pasazer;

@Repository
public class PassangerDAOimp implements PassangerDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Pasazer> getPassangers() {
		Session session = sessionFactory.getCurrentSession();
		List<Pasazer> pasazers;
		try {
			
			Query<Pasazer> query = session.createQuery("from Pasazer order by name",Pasazer.class);
			
			pasazers = query.getResultList();
			
		}catch(Exception e){
			
			pasazers = null;
			
			e.printStackTrace();
		}
		return pasazers;
	}

	@Override
	public void savePassanger(Pasazer pasazer) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(pasazer);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Pasazer getPassanger(int id) {
		Session session = sessionFactory.getCurrentSession();
		Pasazer pasazer;
		try {
			pasazer = session.get(Pasazer.class, id);
		}catch(Exception e){
			e.printStackTrace();
			pasazer = null;
		}
		return pasazer;
	}

	@Override
	public void deletePassanger(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Pasazer pasazer = session.get(Pasazer.class, id);
			
			session.delete(pasazer);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Pasazer> getPassangersByFirstName(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Pasazer> pasazers;
		try {
			
			Query<Pasazer> query = session.createQuery("from Pasazer where first_name like :name",Pasazer.class);
			query.setParameter("name", "%" + name);
			pasazers = query.getResultList();
			
		}catch(Exception e){
			
			pasazers = null;
			
			e.printStackTrace();
		}
		return pasazers;
	}

	@Override
	public List<Pasazer> getPassangersByLastName(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Pasazer> pasazers;
		try {
			
			Query<Pasazer> query = session.createQuery("from Pasazer where last_name like:name",Pasazer.class);
			query.setParameter("name", "%" + name);
			pasazers = query.getResultList();
			
		}catch(Exception e){
			
			pasazers = null;
			
			e.printStackTrace();
		}
		return pasazers;
	}

	@Override
	public List<FlightPassenger> getFlightPassengers()  {
		Session session = sessionFactory.getCurrentSession();
		List<FlightPassenger> pasazers;
		try {
			
			Query<FlightPassenger> query = session.createQuery("from flight_passanger order by name",FlightPassenger.class);
			
			pasazers = query.getResultList();
			
		}catch(Exception e){
			
			pasazers = null;
			
			e.printStackTrace();
		}
		return pasazers;
	}

	@Override
	public void savePassanger(FlightPassenger pasazer)  {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(pasazer);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public FlightPassenger getFlightPassenger(int id)  {
		Session session = sessionFactory.getCurrentSession();
		FlightPassenger pasazer;
		try {
			pasazer = session.get(FlightPassenger.class, id);
		}catch(Exception e){
			e.printStackTrace();
			pasazer = null;
		}
		return pasazer;
	}

	@Override
	public List<FlightPassenger> getFlightPassengersByFirstName(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<FlightPassenger> pasazers;
		try {
			
			Query<FlightPassenger> query = session.createQuery("from flight_passanger where first_name like :name",FlightPassenger.class);
			query.setParameter("name", "%" + name);
			pasazers = query.getResultList();
			
		}catch(Exception e){
			
			pasazers = null;
			
			e.printStackTrace();
		}
		return pasazers;
	}

	@Override
	public List<FlightPassenger> getFlightPassengersByLastName(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<FlightPassenger> pasazers;
		try {
			
			Query<FlightPassenger> query = session.createQuery("from flight_passanger where last_name like:name",FlightPassenger.class);
			query.setParameter("name", "%" + name);
			pasazers = query.getResultList();
			
		}catch(Exception e){
			
			pasazers = null;
			
			e.printStackTrace();
		}
		return pasazers;
	}


	@Override
	public void deleteFlightPassanger(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			FlightPassenger pasazer = session.get(FlightPassenger.class, id);
			
			session.delete(pasazer);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

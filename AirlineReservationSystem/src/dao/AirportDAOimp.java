package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Airport;

@Repository
public class AirportDAOimp implements AirportDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Airport> getAirports() {
		Session session = sessionFactory.getCurrentSession();
		List<Airport> airports;
		try {
			
			Query<Airport> query = session.createQuery("from Airprot order by name",Airport.class);
			
			airports = query.getResultList();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			airports = null;
			
		}
		
	return airports;
	}

	@Override
	public void saveAirport(Airport airport) {
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(airport);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Airport getAirportById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Airport airport;
		try {
			airport =session.get(Airport.class,id);
		}catch(Exception e){
			
			e.printStackTrace();
			
			airport = null;
			
		}
		return airport;
	}

	@Override
	public List<Airport> getAirportsByName(String name){
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Airport> airports;
		try {
			
			Query<Airport> query = session.createQuery("from Airport where name like :name",Airport.class);
			query.setParameter("name", "%" + name);
			
			airports = query.getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
			airports = null;
			
		}
		
		return airports;
	}
	
	@Override
	public void deleteAirport(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Airport airport = session.get(Airport.class, id);
		
			session.delete(airport);
			
		}catch(Exception e){
			
				e.printStackTrace();
				
		}
	}

	@Override
	public List<Integer> getAirportsIdsByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		
		List<Integer> airports;
		try {
			
			Query<Integer> query = session.createQuery("select id from Airport where name like :name",Integer.class);
			query.setParameter("name", "%" + name);
			
			airports = query.getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
			airports = null;
			
		}
		return airports;
	}

}

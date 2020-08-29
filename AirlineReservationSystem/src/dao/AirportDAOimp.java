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
			
		}finally {
			session.close();
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
		}finally {
			session.close();
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
			
		}finally {
			session.close();
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
			
		}finally {
			session.close();
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
				
		}finally {
			session.close();
		}
	}

}

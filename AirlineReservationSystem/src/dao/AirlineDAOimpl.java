package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Airline;

@Repository
public class AirlineDAOimpl implements AirlineDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Airline> getAirlines() {
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Airline> airlines;
		try {
			
			Query<Airline> query = session.createQuery("from Airline order by name",Airline.class);
			
			airlines = query.getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
			airlines = null;
			
		}finally {
			session.close();
		}
		
		return airlines;
	}

	@Override
	public void saveAirline(Airline airline) {
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(airline);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public Airline getAirlineById(int id) {
		
		Airline airline;
		
		Session session = sessionFactory.getCurrentSession();
		try {
			airline = session.get(Airline.class, id);
		}catch(Exception e){
			e.printStackTrace();
			airline = null;
		}finally {
			session.close();
		}
		return airline;
	}

	@Override
	public List<Airline> getAirlinesByName(String name){
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Airline> airlines;
		try {
			
			Query<Airline> query = session.createQuery("from Airline where name like :name",Airline.class);
			query.setParameter("name", "%" + name);
			
			airlines = query.getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
			airlines = null;
			
		}finally {
			session.close();
		}
		
		return airlines;
	}
	
	@Override
	public void deleteAirline(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			Airline airline = session.get(Airline.class, id);
			session.delete(airline);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		
	}

}

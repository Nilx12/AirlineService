package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import entities.FlightAttendant;

@Repository
public class FlightAttendantDAOimp implements FlightAttendantDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<FlightAttendant> getFlightAttendants() {
		Session session = sessionFactory.getCurrentSession();
		List<FlightAttendant> flightAttendants;
		try {
			
			Query<FlightAttendant> query = session.createQuery("from FlightAttendant",FlightAttendant.class);
			
			flightAttendants = query.getResultList();
			
		}catch(Exception e){
			
			flightAttendants = null;
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return flightAttendants;
	}

	@Override
	public void saveFlightAttendant(FlightAttendant flightAttendant) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(flightAttendant);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

	@Override
	public FlightAttendant getFlightAttendantById(int id) {
		Session session = sessionFactory.getCurrentSession();
		FlightAttendant flightAttendant;
		try {
			flightAttendant = session.get(FlightAttendant.class, id);
		}catch(Exception e){
			e.printStackTrace();
			flightAttendant = null;
		}finally {
			session.close();
		}
		return flightAttendant;
	}

	@Override
	public void deleteFlightAttendant(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			FlightAttendant flightAttendant = session.get(FlightAttendant.class, id);
			
			session.delete(flightAttendant);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

}

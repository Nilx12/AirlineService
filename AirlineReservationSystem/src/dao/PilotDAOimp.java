package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Pilot;

@Repository
public class PilotDAOimp implements PilotDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Pilot> getPilots() {
		Session session = sessionFactory.getCurrentSession();
		List<Pilot> pilots;
		try {
			
			Query<Pilot> query = session.createQuery("from Pilot",Pilot.class);
			
			pilots = query.getResultList();
			
		}catch(Exception e){
			
			pilots = null;
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return pilots;
	}

	@Override
	public void savePilot(Pilot pilot) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(pilot);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

	@Override
	public Pilot getPilotById(int id) {

		Session session = sessionFactory.getCurrentSession();
		Pilot pilot;
		try {
			pilot = session.get(Pilot.class, id);
		}catch(Exception e){
			e.printStackTrace();
			pilot = null;
		}finally {
			session.close();
		}
		return pilot;
	}

	@Override
	public void deletePilot(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Pilot pilot = session.get(Pilot.class, id);
			
			session.delete(pilot);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

}

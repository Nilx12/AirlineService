package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Crew;

@Repository
public class CrewDAOimp implements CrewDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Crew> getCrews() {
		Session session = sessionFactory.getCurrentSession();
		List<Crew> crews;
		try {
			
			Query<Crew> query = session.createQuery("from Crew",Crew.class);
			
			crews = query.getResultList();
			
		}catch(Exception e){
			
			crews = null;
			
			e.printStackTrace();
		}
		return crews;
	}

	@Override
	public void saveCrew(Crew crew) {
		
		Session session = sessionFactory.getCurrentSession();
	
		try {
			session.saveOrUpdate(crew);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Crew getCrewById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Crew crew;
		try {
			Query<Crew> query = session.createQuery("from Crew where flight_id=:fid",Crew.class);
			query.setParameter("fid", id);
			crew = query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			crew = null;
		}
		return crew;
	}
	@Override
	public Crew getCrewByFlightId(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Crew crew;
		try {
			 crew = session.get(Crew.class, id);
		}catch(Exception e){
			e.printStackTrace();
			crew = null;
		}
		return crew;
	}
	
	@Override
	public void deleteCrew(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Crew crew = session.get(Crew.class, id);
			
			session.delete(crew);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

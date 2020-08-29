package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		}finally {
			session.close();
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
		}finally {
			session.close();
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
		}finally {
			session.close();
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
		}finally {
			session.close();
		}
	}

	@Override
	public List<Pasazer> getPassangersByFirstName(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Pasazer> pasazers;
		try {
			
			Query<Pasazer> query = session.createQuery("from Pasazer where first_name like",Pasazer.class);
			query.setParameter("name", "%" + name);
			pasazers = query.getResultList();
			
		}catch(Exception e){
			
			pasazers = null;
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return pasazers;
	}

	@Override
	public List<Pasazer> getPassangersByLastName(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Pasazer> pasazers;
		try {
			
			Query<Pasazer> query = session.createQuery("from Pasazer where last_name like",Pasazer.class);
			query.setParameter("name", "%" + name);
			pasazers = query.getResultList();
			
		}catch(Exception e){
			
			pasazers = null;
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return pasazers;
	}

}

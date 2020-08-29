package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Class;

@Repository
public class ClassDAOimp implements ClassDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Class> getClasses() {
		
		Session session = sessionFactory.getCurrentSession();
		List<Class> classes;
		try {
			
			Query<Class> query = session.createQuery("from Class order by name",Class.class);
			
			classes = query.getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
			
			classes = null;
			
		}finally {
			session.close();
		}
		return classes;
	}

	@Override
	public void saveCrew(Class klasa) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(klasa);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

	@Override
	public Class getFlightClass(int id) {
		Session session = sessionFactory.getCurrentSession();
		Class klas;
		try {
			klas = session.get(Class.class, id);
		}catch(Exception e){
			e.printStackTrace();
			klas = null;
		}finally {
			session.close();
		}
		return klas;
	}

	@Override
	public void deleteClass(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Class cla = session.get(Class.class, id);
			
			session.delete(cla);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

}

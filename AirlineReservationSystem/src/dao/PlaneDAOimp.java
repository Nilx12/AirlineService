package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Airline;
import entities.Plane;

@Repository
public class PlaneDAOimp implements PlaneDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Plane> getPlanes() {
		Session session = sessionFactory.getCurrentSession();
		List<Plane> planes;
		try {
			
			Query<Plane> query = session.createQuery("from Plane",Plane.class);
			
			planes = query.getResultList();
			
		}catch(Exception e){
			
			planes = null;
			
			e.printStackTrace();
		}
		
		
		return planes;
	}

	@Override
	public void savePlane(Plane plane) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(plane);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

	@Override
	public Plane getPlane(int id) {
		Session session = sessionFactory.getCurrentSession();
		Plane plane;
		try {
			plane = session.get(Plane.class, id);
		}catch(Exception e){
			e.printStackTrace();
			plane = null;
		}
		
		return plane;
	}

	@Override
	public void deletePlane(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Plane plane = session.get(Plane.class, id);
			
			session.delete(plane);
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	@Override
	public  List<Plane> getPlanesByModel(int id){
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Plane> planes;
		try {
			
			Query<Plane> query = session.createQuery("from Plane where model_id=:id",Plane.class);
			query.setParameter("name", id);
			
			planes = query.getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
			planes = null;
			
		}
		
		return planes;
		
	}
	
}

package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Model;

@Repository
public class ModelDAOimp implements ModelDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Model> getModels() {
		Session session = sessionFactory.getCurrentSession();
		List<Model> models;
		try {
			
			Query<Model> query = session.createQuery("from Model order by name",Model.class);
			
			models = query.getResultList();
			
		}catch(Exception e){
			
			models = null;
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return models;
	}

	@Override
	public void saveModel(Model model) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(model);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

	@Override
	public Model getModelById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Model model;
		try {
			model = session.get(Model.class, id);
		}catch(Exception e){
			e.printStackTrace();
			model = null;
		}finally {
			session.close();
		}
		return model;
	}

	@Override
	public void deleteModel(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Model model = session.get(Model.class, id);
			
			session.delete(model);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

	@Override
	public Model getModelByManufacturer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Model model;
		try {
			Query<Model> query = session.createQuery("from Model where manufacturer_id=:fid",Model.class);
			query.setParameter("fid", id);
			model = query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			model = null;
		}finally {
			session.close();
		}
		return model;
		
	}

	@Override
	public List<Model> getModelsByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		List<Model> models;
		try {
			
			Query<Model> query = session.createQuery("from Model where name like",Model.class);
			query.setParameter("name", "%" + name);
			models = query.getResultList();
			
		}catch(Exception e){
			
			models = null;
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return models;
	}
	
	

}

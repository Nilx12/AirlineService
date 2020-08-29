package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Model;
import entities.User;

@Repository
public class UserDAOimp implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users;
		try {
			
			Query<User> query = session.createQuery("from User",User.class);
			
			users = query.getResultList();
			
		}catch(Exception e){
			
			users = null;
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return users;
	}

	@Override
	public void saveUser(User user) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

	@Override
	public User getUserById(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user;
		try {
			user = session.get(User.class, id);
		}catch(Exception e){
			e.printStackTrace();
			user = null;
		}finally {
			session.close();
		}
		return user;
	}
	
	@Override
	public User getUserByPassenger(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user;
		try {
			Query<User> query = session.createQuery("from User where pasazer_id=:fid",User.class);
			query.setParameter("fid", id);
			user = query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			user = null;
		}finally {
			session.close();
		}
		return user;
		
	}

	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			User user = session.get(User.class, id);
			
			session.delete(user);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}

	}

}

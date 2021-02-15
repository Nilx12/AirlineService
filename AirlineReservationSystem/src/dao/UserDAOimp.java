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
		}
		return user;
	}
	
	@Override
	public User getUserByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		User user;
		try {
			Query<User> query = session.createQuery("from User where login=:login",User.class);
			query.setParameter("login", login);
			if(query.getResultList().isEmpty()) {
				return null;
			}
			user = query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			user = null;
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
		}

	}


}

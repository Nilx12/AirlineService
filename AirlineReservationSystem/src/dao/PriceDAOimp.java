package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Model;
import entities.Price;

@Repository
public class PriceDAOimp implements PriceDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Price> getPrices() {
		Session session = sessionFactory.getCurrentSession();
		List<Price> prices;
		try {
			
			Query<Price> query = session.createQuery("from Price",Price.class);
			
			prices = query.getResultList();
			
		}catch(Exception e){
			
			prices = null;
			
			e.printStackTrace();
		}
		return prices;
	}

	@Override
	public void savePrice(Price price) {
		
		Session session = sessionFactory.getCurrentSession();
	
		try {
			session.saveOrUpdate(price);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public Price getPriceById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Price price;
		try {
			price = session.get(Price.class, id);
		}catch(Exception e){
			e.printStackTrace();
			price = null;
		}
		return price;
	}
	
	@Override
	public  List<Price> getPricesByFlight(int id){
		Session session = sessionFactory.getCurrentSession();
		List<Price> prices;
		try {
			Query<Price> query = session.createQuery("from Price where flight_id=:fid",Price.class);
			query.setParameter("fid", id);
			prices = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			prices = null;
		}
		return prices;
	}
	
	@Override
	public void deletePrice(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Price price = session.get(Price.class, id);
			
			session.delete(price);
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}

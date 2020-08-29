package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import entities.Discount;

@Repository
public class DiscountDAOimp implements DiscountDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Discount> getDiscounts() {
		Session session = sessionFactory.getCurrentSession();
		List<Discount> discounts;
		try {
			
			Query<Discount> query = session.createQuery("from Discount",Discount.class);
			
			discounts = query.getResultList();
			
		}catch(Exception e){
			
			discounts = null;
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return discounts;
	}

	@Override
	public void saveDiscount(Discount discount) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(discount);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public Discount getDiscount(int id) {
		Session session = sessionFactory.getCurrentSession();
		Discount disocunt;
		try {
			disocunt = session.get(Discount.class, id);
		}catch(Exception e){
			e.printStackTrace();
			disocunt = null;
		}finally {
			session.close();
		}
		return disocunt;
	}

	@Override
	public void deleteDiscount(int id) {

		Session session = sessionFactory.getCurrentSession();
		try {
			
			Discount disocunt = session.get(Discount.class, id);
			
			session.delete(disocunt);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

}

package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import entities.Manufacturer;

@Repository
public class ManufacturerDAOimp implements ManufacturerDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Manufacturer> getManufacturers() {
		Session session = sessionFactory.getCurrentSession();
		List<Manufacturer> manufacturers;
		try {
			
			Query<Manufacturer> query = session.createQuery("from Manufacturer order by name",Manufacturer.class);
			
			manufacturers = query.getResultList();
			
		}catch(Exception e){
			
			manufacturers = null;
			
			e.printStackTrace();
		}
		return manufacturers;
	}

	@Override
	public void saveManufacturer(Manufacturer manufacturer) {
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.saveOrUpdate(manufacturer);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public Manufacturer getManufacturer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Manufacturer manufacturer;
		try {
			manufacturer = session.get(Manufacturer.class, id);
		}catch(Exception e){
			e.printStackTrace();
			manufacturer = null;
		}
		return manufacturer;
	}

	@Override
	public void deleteManufacturer(int id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			
			Manufacturer manufacturer = session.get(Manufacturer.class, id);
			
			session.delete(manufacturer);
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}

package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Class;

@Service
public class ClassServiceimp implements ClassService {

	@Autowired
	ClassDAO classDAO;
	
	@Override
	@Transactional
	public  List<Class> getClasses() {
		
		return classDAO.getClasses();
	}

	@Override
	@Transactional
	public void saveCrew(Class klasa) {
		classDAO.saveCrew(klasa);

	}

	@Override
	@Transactional
	public Class getFlightClass(int id) {

		return classDAO.getFlightClass(id);
	}

	@Override
	@Transactional
	public void  deleteClass(int id){
		classDAO.deleteClass(id);

	}

}

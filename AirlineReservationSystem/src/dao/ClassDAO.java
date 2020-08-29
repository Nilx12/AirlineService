package dao;

import java.util.List;

import entities.Class;

public interface ClassDAO {
	
	public  List<Class> getClasses();
	
	public void saveCrew(Class klasa);
	
	public Class getFlightClass(int id);
	
	public void deleteClass(int id);
}

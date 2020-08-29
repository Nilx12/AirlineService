package dao;

import java.util.List;

import entities.Pasazer;

public interface PassangerDAO {
	public  List<Pasazer> getPassangers();
	
	public void savePassanger(Pasazer pasazer);
	
	public Pasazer getPassanger(int id);
	
	public  List<Pasazer> getPassangersByFirstName(String name);
	
	public  List<Pasazer> getPassangersByLastName(String name);
	
	public void deletePassanger(int id);
}

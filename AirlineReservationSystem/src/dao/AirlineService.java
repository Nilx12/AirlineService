package dao;

import java.util.List;

import entities.Airline;
import entities.Plane;

public interface AirlineService {
	
	public  List<Airline> getAirlines();
	
	public void saveAirline(Airline airline);
	
	public Airline getAirlineById(int id);
	
	public List<Airline> getAirlinesByName(String name);
	
	public void deleteAirline(int id);
	
	public void sPlist(int id);
	
	public List<Plane>  gPlist();
}

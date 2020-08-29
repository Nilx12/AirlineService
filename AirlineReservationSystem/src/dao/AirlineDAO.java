package dao;

import java.util.List;

import entities.Airline;

public interface AirlineDAO {
	
	public  List<Airline> getAirlines();
	
	public void saveAirline(Airline airline);
	
	public Airline getAirlineById(int id);
	
	public List<Airline> getAirlinesByName(String name);
	
	public void deleteAirline(int id);
}

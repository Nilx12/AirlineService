package dao;

import java.util.List;

import entities.Airport;

public interface AirportDAO {

	public  List<Airport> getAirports();
	
	public void saveAirport(Airport airport);
	
	public Airport getAirportById(int id);

	public List<Airport> getAirportsByName(String name);
	
	public List<Integer> getAirportsIdsByName(String name);
	
	public void deleteAirport(int id);
}

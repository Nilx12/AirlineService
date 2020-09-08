package dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import entities.Flight;

public interface FlightDAO {
	
	public  List<Flight> getFlights(Date date);
	
	public void saveCrew(Flight flight);
	
	public Flight getFlightById(int id);
	
	public Flight getFlightByOriginAirport(int id,Date date);
	
	public List<Flight> getFlightByDesitinyAndOriginAirport(int originId,int desitnityi,Date date);
	
	public List<Flight> getFlightByDesitinyAndOriginAirport(List<Integer> originId,List<Integer> desitnityid,Date date);
	
	public Flight getFlightByAirline(int id);
	
	public void deleteFlight(int id);
}

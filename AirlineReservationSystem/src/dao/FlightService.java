package dao;

import java.util.List;

import entities.Flight;

public interface FlightService {
	
	public  List<Flight> getFlights();
	
	public void saveCrew(Flight flight);
	
	public Flight getFlightById(int id);
	
	public Flight getFlightByOriginAirport(int id);
	
	public Flight getFlightByDesitinyAirport(int id);
	
	public Flight getFlightByAirline(int id);
	
	public void deleteFlight(int id);
}

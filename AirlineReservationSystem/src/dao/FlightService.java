package dao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import entities.Flight;

public interface FlightService {
	
	public  List<Flight>  getFlights(Date date);
	
	public void saveCrew(Flight flight);
	
	public Flight getFlightById(int id);
	
	public Flight getFlightByOriginAirport(int id,Date date);

	public List<Flight> getFlightByDesitinyAndOriginAirport(int originId,int desitnityid,Date date,LocalTime time);
	
	public List<Flight> getFlightByDesitinyAndOriginAirport(int originId,int desitnityid,Date date);
	
	public Flight getFlightByAirline(int id);
	
	public void deleteFlight(int id);
}

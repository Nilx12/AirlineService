package dao;

import java.util.List;

import entities.FlightPassenger;
import entities.Pasazer;

public interface PassangerDAO {
	public  List<Pasazer> getPassangers();
	
	public void savePassanger(Pasazer pasazer);
	
	public Pasazer getPassanger(int id);
	
	public  List<Pasazer> getPassangersByFirstName(String name);
	
	public  List<Pasazer> getPassangersByLastName(String name);
	
	public void deletePassanger(int id);
	
	public  List<FlightPassenger> getFlightPassengers();
	
	public void savePassanger(FlightPassenger pasazer);
	
	public FlightPassenger getFlightPassenger(int id);
	
	public  List<FlightPassenger> getFlightPassengersByFirstName(String name);
	
	public  List<FlightPassenger> getFlightPassengersByLastName(String name);
	
	public void deleteFlightPassanger(int id);
}

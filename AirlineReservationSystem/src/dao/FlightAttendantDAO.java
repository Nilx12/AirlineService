package dao;

import java.util.List;

import entities.FlightAttendant;

public interface FlightAttendantDAO {
	
	public  List<FlightAttendant> getFlightAttendants();
	
	public void saveFlightAttendant(FlightAttendant flightAttendant);
	
	public FlightAttendant getFlightAttendantById(int id);
	
	public void deleteFlightAttendant(int id);
	
	/* public FlightAttendant getFlightAttendantByFirstName(String name);
	
	public FlightAttendant getFlightAttendantBySecondName(String name); */
}

package dao;

import java.util.List;

import entities.FlightAttendant;
import entities.Pilot;

public interface EmplyeService {

	public  List<FlightAttendant> getFlightAttendants();
	
	public void saveFlightAttendant(FlightAttendant flightAttendant);
	
	public FlightAttendant getFlightAttendantById(int id);
	
	/* public FlightAttendant getFlightAttendantByFirstName(String name);
	
	public FlightAttendant getFlightAttendantBySecondName(String name); */
	
	public void deleteFlightAttendant(int id);
	
	public  List<Pilot> getPilots();
	
	public void savePilot(Pilot pilot);
	
	public Pilot getPilotById(int id);
	
	/* public  List<Pilot> getPilotsByFirstName(String name);
	
	public  List<Pilot> getPilotsByFirstName(String name); */
	
	public void deletePilot(int id);
	
	
}

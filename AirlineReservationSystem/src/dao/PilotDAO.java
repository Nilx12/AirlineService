package dao;

import java.util.List;

import entities.Pilot;

public interface PilotDAO {
	
	public  List<Pilot> getPilots();
	
	public void savePilot(Pilot pilot);
	
	public Pilot getPilotById(int id);
	
	public void deletePilot(int id);
	
	/* public  List<Pilot> getPilotsByFirstName(String name);
	
	public  List<Pilot> getPilotsByFirstName(String name); */
}

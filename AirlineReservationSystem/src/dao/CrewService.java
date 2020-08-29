package dao;

import java.util.List;

import entities.Crew;

public interface CrewService {
	
	public  List<Crew> getCrews();
	
	public void saveCrew(Crew crew);
	
	public Crew getCrewById(int id);
	
	public Crew getCrewByFlightId(int id);
	
	public void deleteCrew(int id);
	
	
}

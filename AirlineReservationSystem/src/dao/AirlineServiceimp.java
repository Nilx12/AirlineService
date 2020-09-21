package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Airline;
import entities.Class;
import entities.Flight;
import entities.Plane;
@Service
public class AirlineServiceimp implements AirlineService {

	@Autowired
	AirlineDAO airlineDAO;
	
	List<Plane> plist;
	
	@Override
	@Transactional
	public void sPlist(int id){
		if(plist == null) {
			plist = new ArrayList<Plane>();
		}else {
			plist.clear();
		}
		Airline airline = getAirlineById(id);
		for(Plane plan:airline.getPlanes()) {
			plist.add(plan);
		}
	}
	
	@Override
	public List<Plane>  gPlist(){
		return plist;
		
	}
	
	@Override
	@Transactional
	public List<Airline> getAirlines() {
		return airlineDAO.getAirlines();
	}

	@Override
	@Transactional
	public void saveAirline(Airline airline) {
		airlineDAO.saveAirline(airline);
	}

	@Override
	@Transactional
	public Airline getAirlineById(int id) {
		return airlineDAO.getAirlineById(id);
	}

	@Override
	@Transactional
	public List<Airline> getAirlinesByName(String name) {
		if(name == null) {
			return null;
		}
		return airlineDAO.getAirlinesByName(name.trim());
	}

	@Override
	@Transactional
	public void deleteAirline(int id) {
		airlineDAO.deleteAirline(id);

	}

}

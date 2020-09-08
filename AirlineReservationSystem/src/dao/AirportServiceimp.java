package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Airport;

@Service
public class AirportServiceimp implements AirportService {

	@Autowired
	AirportDAO airportDAO;
	
	
	@Override
	@Transactional
	public List<Airport> getAirports() {
		return airportDAO.getAirports();
	}

	@Override
	@Transactional
	public void saveAirport(Airport airport) {
		airportDAO.saveAirport(airport);

	}

	@Override
	@Transactional
	public Airport getAirportById(int id) {
		return airportDAO.getAirportById(id);
	}

	@Override
	@Transactional
	public List<Airport> getAirportsByName(String name) {
		if(name == null) {
			return null;
		}
		return airportDAO.getAirportsByName(name.trim());
	}

	@Override
	@Transactional
	public Airport getAirportByName(String name) {
		if(name == null) {
			return null;
		}
		
		List<Airport> airports = airportDAO.getAirportsByName(name.trim());
		
		if(airports.size() == 0)
			return null;
		Airport airprot = airports.get(0);
		return airprot;
	}
	
	@Override
	@Transactional
	public List<Integer> getAirportsIdsByName(String name){
		
		if(name == null) {
			return null;
		}
		
		List<Integer> airports = airportDAO.getAirportsIdsByName(name.trim());
		
		if(airports.size() == 0)
			return null;
		return airports;
	}
	
	@Override
	@Transactional
	public void deleteAirport(int id) {
		airportDAO.deleteAirport(id);

	}

}

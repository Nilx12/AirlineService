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
	public void deleteAirport(int id) {
		airportDAO.deleteAirport(id);

	}

}

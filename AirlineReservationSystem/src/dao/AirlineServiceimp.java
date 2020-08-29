package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Airline;
@Service
public class AirlineServiceimp implements AirlineService {

	@Autowired
	AirlineDAO airlineDAO;
	
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

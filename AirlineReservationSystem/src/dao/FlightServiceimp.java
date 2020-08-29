package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Flight;

@Service
public class FlightServiceimp implements FlightService {

	@Autowired
	FlightDAO flightDAO;
	
	@Override
	@Transactional
	public List<Flight> getFlights() {
		return flightDAO.getFlights();
	}

	@Override
	@Transactional
	public void saveCrew(Flight flight) {
		flightDAO.saveCrew(flight);

	}

	@Override
	@Transactional
	public Flight getFlightById(int id) {

		return flightDAO.getFlightById(id);
	}

	@Override
	@Transactional
	public Flight getFlightByOriginAirport(int id) {
		return flightDAO.getFlightByOriginAirport(id);
	}

	@Override
	@Transactional
	public Flight getFlightByDesitinyAirport(int id) {
		return flightDAO.getFlightByDesitinyAirport(id);
	}

	@Override
	@Transactional
	public Flight getFlightByAirline(int id) {
		return flightDAO.getFlightByAirline(id);
	}

	@Override
	@Transactional
	public void deleteFlight(int id) {
		flightDAO.deleteFlight(id);

	}

}

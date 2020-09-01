package dao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
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
	public List<Flight>  getFlights(Date date) {
		return flightDAO.getFlights(date);
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
	public Flight getFlightByOriginAirport(int id,Date date) {
		return flightDAO.getFlightByOriginAirport(id,date);
	}

	@Override
	@Transactional
	public List<Flight> getFlightByDesitinyAndOriginAirport(int originId,int desitnityid,Date date, LocalTime time) {
		
		LocalTime minTime = time;
		minTime.minusHours(5);
		
		LocalTime maxTime = time;
		minTime.plusHours(5);
		
		List<Flight> flights = flightDAO.getFlightByDesitinyAndOriginAirport( originId, desitnityid,date);
		
		List<Flight> flightsByDate = new ArrayList<Flight>();		
		
		flights.stream()
			.filter(flight -> flight.getTime().isAfter(minTime) && flight.getTime().isBefore(maxTime))
			.forEach(flight -> flightsByDate.add(flight));
		
		return flights;
	}
	
	@Override
	@Transactional
	public List<Flight> getFlightByDesitinyAndOriginAirport(int originId,int desitnityid,Date date) {
		return flightDAO.getFlightByDesitinyAndOriginAirport( originId, desitnityid,date);
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

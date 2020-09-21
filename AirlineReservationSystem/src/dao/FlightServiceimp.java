package dao;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Flight;
import entities.Class;

@Service
public class FlightServiceimp implements FlightService {

	@Autowired
	FlightDAO flightDAO;
	
	List<Class> flist;
	
	@Override
	@Transactional
	public void sFlist(int id){
		if(flist == null) {
			flist = new ArrayList<Class>();
		}else {
			flist.clear();
		}
		Flight flight = getFlightById(id);
		for(Class klasy:flight.getClasses()) {
			System.out.println(klasy.getName());
			flist.add(klasy);
		}
	}
	
	@Override
	public List<Class> gFlist(){
		return flist;
		
	}
	
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
		
		
		List<Flight> flightsByDate =flightDAO.getFlightByDesitinyAndOriginAirport( originId, desitnityid,date)
				.stream()
				.filter(flight -> flight.getTime().isAfter(minTime) && flight.getTime().isBefore(maxTime))
				.collect(Collectors.toList());

		
		return flightsByDate;
	}
	
	@Override
	@Transactional
	public List<Flight> getFlightByDesitinyAndOriginAirport(List<Integer> originId,List<Integer> desitnityid,Date date, LocalTime time){
		
		LocalTime minTime = time.minusHours(5);
		LocalTime maxTime = time.plusHours(5);
		
		Calendar calendar = Calendar.getInstance(); 
		List<Flight> flightsByDate = flightDAO.getFlightByDesitinyAndOriginAirport( originId, desitnityid,date);
	
		if(maxTime.isBefore(time)) {
			calendar.setTime(date); 
			calendar.add(Calendar.DATE, 1);
			Date NextDay = new Date(calendar.getTime().getTime());
			
			flightsByDate = flightsByDate
					.stream()
					.filter(flight -> flight.getTime().isAfter(minTime))
					.collect(Collectors.toList());
			
			flightsByDate.addAll(flightDAO.getFlightByDesitinyAndOriginAirport( originId, desitnityid,NextDay)
					.stream()
					.filter(flight -> flight.getTime().isBefore(maxTime))
					.collect(Collectors.toList())
				);
		} 
		
		if(minTime.isAfter(time)) {
			calendar.setTime(date); 
			calendar.add(Calendar.DATE, -1);
			Date PrevDay = new Date(calendar.getTime().getTime());
			
			flightsByDate = flightsByDate
					.stream()
					.filter(flight -> flight.getTime().isBefore(maxTime))
					.collect(Collectors.toList());
			
			flightsByDate.addAll(flightDAO.getFlightByDesitinyAndOriginAirport( originId, desitnityid,PrevDay)
					.stream()
					.filter(flight -> flight.getTime().isAfter(minTime))
					.collect(Collectors.toList())
				);
		}
		
		if(minTime.isBefore(time) && maxTime.isAfter(time)){
			flightsByDate = flightsByDate
			.stream()
			.filter(flight -> flight.getTime().isAfter(minTime) && flight.getTime().isBefore(maxTime))
			.collect(Collectors.toList());
		}
		
		
		return flightsByDate;
	}
	
	@Override
	@Transactional
	public List<Flight> getFlightByDesitinyAndOriginAirport(List<Integer> originId,List<Integer> desitnityid,Date date){
		
		List<Flight> flightsByDate = flightDAO.getFlightByDesitinyAndOriginAirport( originId, desitnityid,date);
		
		
		
		return flightsByDate;
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

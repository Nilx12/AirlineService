package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.FlightAttendant;
import entities.Pilot;

@Service
public class EmployeServiceimp implements EmplyeService {

	@Autowired
	FlightAttendantDAO flightAttendantDAO;
	
	@Autowired
	PilotDAO pilotDAO;
	
	@Override
	@Transactional
	public List<FlightAttendant> getFlightAttendants() {
		flightAttendantDAO.getFlightAttendants();
		return null;
	}

	@Override
	@Transactional
	public void saveFlightAttendant(FlightAttendant flightAttendant) {
		flightAttendantDAO.saveFlightAttendant(flightAttendant);

	}

	@Override
	@Transactional
	public FlightAttendant getFlightAttendantById(int id) {
		
		return flightAttendantDAO.getFlightAttendantById(id);
	}

	@Override
	@Transactional
	public void deleteFlightAttendant(int id) {
		flightAttendantDAO.deleteFlightAttendant(id);

	}

	@Override
	@Transactional
	public List<Pilot> getPilots() {
		return pilotDAO.getPilots();
	}

	@Override
	@Transactional
	public void savePilot(Pilot pilot) {
		pilotDAO.savePilot(pilot);

	}

	@Override
	@Transactional
	public Pilot getPilotById(int id) {
		return pilotDAO.getPilotById(id);
	}

	@Override
	@Transactional
	public void deletePilot(int id) {
		pilotDAO.deletePilot(id);
	}

}

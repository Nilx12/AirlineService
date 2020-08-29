package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Crew;

@Service
public class CrewServiceimp implements CrewService {

	@Autowired
	CrewDAO crewDAO;
	
	@Override
	@Transactional
	public List<Crew> getCrews() {
		// TODO Auto-generated method stub
		return crewDAO.getCrews();
	}

	@Override
	@Transactional
	public void saveCrew(Crew crew) {
		crewDAO.saveCrew(crew);

	}

	@Override
	@Transactional
	public Crew getCrewById(int id) {
		
		return crewDAO.getCrewById(id);
	}

	@Override
	@Transactional
	public Crew getCrewByFlightId(int id) {
		return crewDAO.getCrewByFlightId(id);
	}

	@Override
	@Transactional
	public void deleteCrew(int id) {
		crewDAO.deleteCrew(id);

	}

}

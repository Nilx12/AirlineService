package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Plane;

@Service
public class PlaneServiceimp implements PlaneService {

	@Autowired
	PlaneDAO planeDAO;
	
	@Override
	@Transactional
	public List<Plane> getPlanes() {
		
		return planeDAO.getPlanes();
	}

	@Override
	@Transactional
	public void savePlane(Plane plane) {
		planeDAO.savePlane(plane);

	}

	@Override
	@Transactional
	public Plane getPlane(int id) {
		return planeDAO.getPlane(id);
	}

	@Override
	@Transactional
	public List<Plane> getPlanesByModel(int id) {
		return planeDAO.getPlanesByModel(id);
	}

	@Override
	@Transactional
	public void deletePlane(int id) {
		planeDAO.deletePlane(id);

	}

}

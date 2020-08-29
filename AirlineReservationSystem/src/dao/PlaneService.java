package dao;

import java.util.List;

import entities.Plane;

public interface PlaneService {

	public  List<Plane> getPlanes();
	
	public void savePlane(Plane plane);
	
	public Plane getPlane(int id);
	
	public  List<Plane> getPlanesByModel(int id);
	
	public void deletePlane(int id);
	
}

package dao;

import java.util.List;

import entities.Manufacturer;

public interface ManufacturerDAO {
	
	public  List<Manufacturer> getManufacturers();
	
	public void saveManufacturer(Manufacturer manufacturer);
	
	public Manufacturer getManufacturer(int id);
	
	public void deleteManufacturer(int id);
	
}

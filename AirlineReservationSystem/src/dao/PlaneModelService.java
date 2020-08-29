package dao;

import java.util.List;

import entities.Manufacturer;
import entities.Model;

public interface PlaneModelService {
	public  List<Model> getModels();
	
	public void saveModel(Model model);
	
	public Model getModelById(int id);
	
	public  List<Model> getModelsByName(String name);
	
	public Model getModelByManufacturer(int id);
	
	public  List<Manufacturer> getManufacturers();
	
	public void saveManufacturer(Manufacturer manufacturer);
	
	public Manufacturer getManufacturer(int id);
	
	public void deleteManufacturer(int id);
}

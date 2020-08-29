package dao;

import java.util.List;

import entities.Model;

public interface ModelDAO {
	
	public  List<Model> getModels();
	
	public void saveModel(Model model);
	
	public Model getModelById(int id);
	
	public void deleteModel(int id);
	
	public Model getModelByManufacturer(int id);
	
	public  List<Model> getModelsByName(String name);
}

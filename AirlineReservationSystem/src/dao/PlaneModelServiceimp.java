package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Manufacturer;
import entities.Model;

@Service
public class PlaneModelServiceimp implements PlaneModelService {

	@Autowired
	ModelDAO modelDAO;
	
	@Autowired
	ManufacturerDAO manufacturerDAO;
	
	@Override
	@Transactional
	public List<Model> getModels() {
		return modelDAO.getModels();
	}

	@Override
	@Transactional
	public void saveModel(Model model) {
		modelDAO.saveModel(model);

	}

	@Override
	@Transactional
	public Model getModelById(int id) {
	
		return modelDAO.getModelById(id);
	}

	@Override
	@Transactional
	public List<Model> getModelsByName(String name) {
		if(name == null) {
			return null;
		}
		return modelDAO.getModelsByName(name.trim());
	}


	@Override
	@Transactional
	public Model getModelByManufacturer(int id) {
		return modelDAO.getModelByManufacturer(id);

	}

	@Override
	@Transactional
	public List<Manufacturer> getManufacturers() {
		return manufacturerDAO.getManufacturers();
	}

	@Override
	@Transactional
	public void saveManufacturer(Manufacturer manufacturer) {
		manufacturerDAO.saveManufacturer(manufacturer);
	}

	@Override
	@Transactional
	public Manufacturer getManufacturer(int id) {
		return manufacturerDAO.getManufacturer(id);
	}

	@Override
	@Transactional
	public void deleteManufacturer(int id) {
		manufacturerDAO.deleteManufacturer(id);
	}

}

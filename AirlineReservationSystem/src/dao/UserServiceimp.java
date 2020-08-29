package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Pasazer;
import entities.User;

@Service
public class UserServiceimp implements UserService {

	
	@Autowired
	PassangerDAO passangerDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	@Transactional
	public List<Pasazer> getPassangers() {
		
		return passangerDAO.getPassangers();
	}

	@Override
	@Transactional
	public void savePassanger(Pasazer pasazer) {
		passangerDAO.savePassanger(pasazer);

	}

	@Override
	@Transactional
	public Pasazer getPassanger(int id) {

		return passangerDAO.getPassanger(id);
	}

	@Override
	@Transactional
	public List<Pasazer> getPassangersByFirstName(String name) {
		if(name == null) {
			return null;
		}
		return passangerDAO.getPassangersByFirstName(name.trim());
	}

	@Override
	@Transactional
	public List<Pasazer> getPassangersByLastName(String name) {
		if(name == null) {
			return null;
		}
		return passangerDAO.getPassangersByLastName(name.trim());
	}

	@Override
	@Transactional
	public void deletePassanger(int id) {
		passangerDAO.deletePassanger(id);
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);

	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public User getUserByPassenger(int id) {
		return userDAO.getUserByPassenger(id);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);

	}

}

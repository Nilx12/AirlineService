package dao;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Pasazer;
import entities.User;

@Service
public class UserServiceimp implements UserService {
	
	/*@Autowired
	PasswordEncoder PasswordEncoder;*/
	
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
	public Boolean registerUser(User user) {
		
		saveUser(user);
		
		return null;
	}

	@Override
	@Transactional
	public Boolean loginUser(User user, String password) throws NoSuchAlgorithmException {	

		return user.proceedPassword(password);
	}


	@Override
	@Transactional
	public User getUserByLogin(String login) {
		if(login == null || login.equals(""))
			return null;
		
		return userDAO.getUserByLogin(login);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);

	}
}

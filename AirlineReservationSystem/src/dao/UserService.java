package dao;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import entities.Pasazer;
import entities.User;

public interface UserService {
	
	public  List<Pasazer> getPassangers();
	
	public void savePassanger(Pasazer pasazer);
	
	public Pasazer getPassanger(int id);
	
	public  List<Pasazer> getPassangersByFirstName(String name);
	
	public  List<Pasazer> getPassangersByLastName(String name);
	
	public void deletePassanger(int id);
	
	public  List<User> getUsers();
	
	public void saveUser(User user);
	
	public Boolean registerUser(User user);
	
	public Boolean loginUser(User user,String password) throws NoSuchAlgorithmException;
	
	public User getUserById(int id);
	
	public User getUserByLogin(String login);
	
	public User getUserByEmail(String email);
	
	public User getUserByPassenger(int id);
	
	public void deleteUser(int id);
}

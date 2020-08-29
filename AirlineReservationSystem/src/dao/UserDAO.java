package dao;

import java.util.List;

import entities.User;


public interface UserDAO {

	public  List<User> getUsers();
	
	public void saveUser(User user);
	
	public User getUserById(int id);
	
	public User getUserByPassenger(int id);
	
	public void deleteUser(int id);
	
	
}

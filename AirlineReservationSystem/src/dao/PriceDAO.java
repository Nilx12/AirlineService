package dao;

import java.util.List;

import entities.Price;

public interface PriceDAO {
	
	public  List<Price> getPrices();
	
	public void savePrice(Price price);
	
	public Price getPriceById(int id);
	
	public  List<Price> getPricesByFlight(int id);
	
	public void deletePrice(int id);
}

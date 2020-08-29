package dao;

import java.util.List;

import entities.Discount;

public interface DiscountDAO {
	
	public  List<Discount> getDiscounts();
	
	public void saveDiscount(Discount discount);
	
	public Discount getDiscount(int id);
	
	public void deleteDiscount(int id);
}

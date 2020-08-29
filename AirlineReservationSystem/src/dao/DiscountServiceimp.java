package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import entities.Discount;

@Service
public class DiscountServiceimp implements DiscountService {

	@Autowired
	DiscountDAO disocuntDAO;
	
	@Override
	@Transactional
	public List<Discount> getDiscounts() {
		return disocuntDAO.getDiscounts();
	}

	@Override
	@Transactional
	public void saveDiscount(Discount discount) {
		disocuntDAO.saveDiscount(discount);

	}

	@Override
	@Transactional
	public Discount getDiscount(int id) {
		
		return disocuntDAO.getDiscount(id);
	}

	@Override
	@Transactional
	public void deleteDiscount(int id) {
		disocuntDAO.deleteDiscount(id);

	}

}

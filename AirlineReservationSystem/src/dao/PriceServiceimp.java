package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.Price;

@Service
public class PriceServiceimp implements PriceService {

	@Autowired
	PriceDAO pricedao;
	
	@Override
	@Transactional
	public List<Price> getPrices() {
		return pricedao.getPrices();
	}

	@Override
	@Transactional
	public void savePrice(Price price) {
		pricedao.savePrice(price);

	}

	@Override
	@Transactional
	public Price getPriceById(int id) {
		return pricedao.getPriceById(id);
	}

	@Override
	@Transactional
	public List<Price> getPricesByFlight(int id) {
		return pricedao.getPricesByFlight(id);
	}

	@Override
	@Transactional
	public void deletePrice(int id) {
		pricedao.deletePrice(id);
	}

}

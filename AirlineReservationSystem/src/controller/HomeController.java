package controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.*;
import entities.*;

@Controller
public class HomeController {

	@Autowired
	private FlightService service;
	
	@RequestMapping("/")
	public String frontPage(){
		
		Date date = new Date(12223213);
		List<Flight> list = service.getFlightByDesitinyAndOriginAirport(1,1, date);
		
		return "frontPage";
	}
	@RequestMapping("/login")
	public String loginUserPage(){
		return "loginPage";
	}
	@RequestMapping("/register")
	public String registerUSerPage(){
		return "registerPage";
	}
}


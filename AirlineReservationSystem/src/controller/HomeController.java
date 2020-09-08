package controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.*;
import entities.*;
import searchers.FligthSearcher;

@Controller
public class HomeController {

	@Autowired
	private AirportService service;
	
	@Autowired
	private AirlineService airlineservice;
	
	@Autowired
	private EmplyeService emplyeService;
	
	@Autowired
	private CrewService crewService;
	
	@Autowired
	private PlaneService planeService;
	
	@Autowired
	private PlaneModelService modelService;
	
	@Autowired
	private FlightService flightService;
	
	@RequestMapping("/")
	public String frontPage(){
		
		
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
	@RequestMapping("/searchFlight")
	public String getFlightSearchPage(Model model){
		
		
		FligthSearcher fs = new FligthSearcher();
		
		model.addAttribute("fligthSearcher",fs);
		
		return "flightSearch";
	}
	@RequestMapping("/getFlight")
	public String getFlight( Model model,@Valid @ModelAttribute("fligthSearcher") FligthSearcher searchs,BindingResult br){

		if(br.hasErrors())
			return "flightSearch";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date date=new java.util.Date();
		
		List<Integer> orAirports = service.getAirportsIdsByName(searchs.getOriginAirport());
		List<Integer> deAirports = service.getAirportsIdsByName(searchs.getDesitinyAirport());
		
		List <Flight> flights = flightService.getFlightByDesitinyAndOriginAirport(orAirports, deAirports, new Date(date.getTime()),searchs.convertTime());
		
		model.addAttribute("flights",flights); 
		
		return "flightList";
	}
}


package controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import dao.*;
import entities.*;
import entities.Class;
import searchers.FligthSearcher;

@Controller
@SessionAttributes("currentUser")
@RequestMapping("/")
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
	
	@Autowired
	private TicketService ticketService;
	
	@ModelAttribute("user")
	public User adduser(@SessionAttribute(value="currentUser",required= false) User user){
		return user;
	}
	
	
	
	@RequestMapping("/")
	public String frontPage(Model model/* ,@SessionAttribute("currentUser") User user */){
		
		//model.addAttribute("user",user);
		return "frontPage";
	}
	
	@ExceptionHandler(ServletRequestBindingException.class)
	public String handle(Model model){
		model.addAttribute("currentUser", null);
		return "redirect:/login";
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
	
	@GetMapping("/buyTicket")
	public String deleteUser(@RequestParam("fligthId") int id,Model model) {
		Flight flight = flightService.getFlightById(id);
		model.addAttribute("flight",flight);
		flightService.sFlist(id);
		List<Class> fl = flightService.gFlist();
		
		model.addAttribute("flightClasses", fl);
	
		return "ticketPage";
	}
	
	@GetMapping("/profile")
	public String getProfile(Model model, @ModelAttribute("user") User user) {
		
		if(user == null) {
			return "frontPage";
		}
		
		List<Ticket> tickets = ticketService.getTicketsByPassenger(user.getId()) ;
		if(tickets != null && !tickets.isEmpty()) {
			model.addAttribute("ticket",tickets.get(tickets.size() - 1));
		}else {
			model.addAttribute("ticket",null);
		}
		return "profilePage";
		
	}
	
	
	@GetMapping("/ticketHistory")
	public String showTicketHistory(Model model, @ModelAttribute("user") User user) {
		
		if(user == null) {
			return "redirect:/";
		}
		
		List<Ticket> tickets = ticketService.getTicketsByPassenger(user.getId()) ;
		if(tickets != null && !tickets.isEmpty()) {
			model.addAttribute("tickets",tickets);
		}
		return "ticketList";
		
	}
	
}


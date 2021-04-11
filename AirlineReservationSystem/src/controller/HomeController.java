package controller;

import java.security.NoSuchAlgorithmException;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import dao.*;
import entities.*;
import entities.Class;
import searchers.FligthSearcher;
import searchers.PaymentOverseer;
import searchers.TicketOverser;
import searchers.UserDataActualisation;

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
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DiscountService discountService;
	
	@Autowired
	private SeatService seatService;
	
	
	@ModelAttribute("user")
	public User adduser(@SessionAttribute(value="currentUser",required= false) User user){
		if(user != null)
		System.out.println("sesja: "+user.getPassword());
		return user;
	}
	
	
	
	@RequestMapping("/")
	public String frontPage(Model model ,@ModelAttribute("user") User user ){
		//model.addAttribute("user",user);
		return "frontPage";
	}
	

	
	@RequestMapping("/searchFlight")
	public String getFlightSearchPage(Model model){
		
		FligthSearcher fs = new FligthSearcher();
		
		model.addAttribute("fligthSearcher",fs);
		
		return "flightSearch";
	}
	@GetMapping("/getFlight")
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
	
	@GetMapping("/buyTicket/{id}")
	public String deleteUser(Model model, @PathVariable("id") int id) {
		Flight flight = flightService.getFlightById(id);
		
		if(flight == null) {
			return "noTicket";
		}
		
		model.addAttribute("flight",flight);
		
		TicketOverser ticket = new TicketOverser();
		
		ticket.setFlight(flight);
		
		flightService.sFlist(id);
		List<entities.Class> fl = flightService.gFlist();
		List<Seat> seats = seatService.getSeatSetByplane(flight.getPlane().getId()).getSeats();
		model.addAttribute("avaiableSeats", seats);
		List <Discount> discounts = discountService.getDiscounts();
		model.addAttribute("discounts", discounts);
		model.addAttribute("flightClasses", fl);
	
		return "ticketPage";
	}
	@PostMapping("/ticketShop")
	public String buyTicket(Model model,@Valid @ModelAttribute("ticketProperty") TicketOverser ticketToBuy, @ModelAttribute("user") User user) {
		
		Ticket ticket = new Ticket();
		
		Discount discount = discountService.getDiscount(ticketToBuy.getDiscountId());
		
		Seat seat = seatService.getSeatById(ticketToBuy.getSeatId());
		
		FlightPassenger passenger = new FlightPassenger(ticketToBuy.getName(),ticketToBuy.getSurname(), user.getEmail(), discount,seat);
		
		ticket.addFlight(ticketToBuy.getFlight());
		
		ticket.setEmail(ticketToBuy.getEmail());
		
		ticket.addPassanger(passenger);
		
		ticketService.saveTicket(ticket);
		
		PaymentOverseer po = new PaymentOverseer(ticket.getId(),ticket.getPriceVal());
		
		model.addAttribute("payment",po);
		
		model.addAttribute("ticket",ticket);
		
		return "PaymentPage";
	}
	
	@GetMapping("/profile")
	public String getProfile(Model model, @ModelAttribute("user") User user) {
		
		if(user == null) {
			return "redirect:/";
		}
		
		List<Ticket> tickets = ticketService.getTicketsByEmail(user.getEmail());
		if(tickets != null && !tickets.isEmpty()) {
			model.addAttribute("ticket",tickets.get(tickets.size() - 1));
		}else {
			model.addAttribute("ticket",null);
		}
		return "profilePage";
		
	}
	@RequestMapping("/profile/edit")
	public String editDane(Model model, @ModelAttribute("user") User user) {

		if(user == null) {
			return "redirect:/";
		}
		UserDataActualisation uda = new UserDataActualisation();
		
		model.addAttribute("userDataUpdate",uda);
		
		return "dataUpdatePage";
		
	}
	
	@PostMapping("/profile/update")
	public String updateUserData(Model model,@Valid @ModelAttribute("userDataUpdate") UserDataActualisation uda, @ModelAttribute("user") User user) throws NoSuchAlgorithmException {
		
		if(!userService.loginUser(user, uda.getPas())) {
			return "dataUpdatePage";
		}
		
		if(user.getLogin().equals(uda.getLogin())) {
			user.setLogin(uda.getLogin());
		}
		if(user.getEmail().equals(uda.getEmail())) {
			user.setEmail(uda.getEmail());
		}
		
		if(user.getPasazer() == null) {
			if(uda.getName() != null && uda.getSurname() != null) {
				Pasazer pasazer = new Pasazer(uda.getName(),uda.getSurname(),uda.getEmail());
				userService.savePassanger(pasazer);
				user.setPasazer(pasazer);
			}
		}else {
			if(uda.getName() != null) {
				user.getPasazer().setFirstName(uda.getName());
			}
			if(uda.getSurname() != null) {
				user.getPasazer().setLastName(uda.getSurname());
			}
			if(user.getPasazer().getEmail().equals(uda.getEmail())) {
				user.getPasazer().setEmail(uda.getEmail());
			}
			userService.savePassanger(user.getPasazer());
		}
		
		userService.saveUser(user);
		return "redirect:/";
	}
	
	@ExceptionHandler(NoSuchAlgorithmException.class)
	public String handleException(){
		return "exceptionPage";
	}
	
	
	@RequestMapping("/ticketHistory")
	public String showTicketHistory(Model model, @ModelAttribute("user") User user) {
		
		if(user == null) {
			return "redirect:/";
		}
		
		List<Ticket> tickets = ticketService.getTicketsByPassenger(user.getPasazer().getId()) ;
		if(tickets != null && !tickets.isEmpty()) {
			model.addAttribute("tickets",tickets);
		}
		return "ticketList";
		
	}
	@GetMapping("/ticket/{id}")
	public String loadTicketPage(Model model,@PathVariable("id") int id, @ModelAttribute("user") User user) {
		
		Ticket ticket = ticketService.getTicketById(id);
		if(ticket == null) {
			return "noTicket";
		}
		List<Ticket> tickets = ticketService.getTicketsByPassenger(user.getPasazer().getId());
		if(!tickets.contains(ticket)) {
			return "redirect:/";
		}
		
		model.addAttribute("ticket",ticket);
		
		return "ticketInfo";
		
	}
	

}


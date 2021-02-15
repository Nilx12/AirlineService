package controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dao.UserService;
import entities.User;
import searchers.UserRegistrationOverseer;
import searchers.UserLoginOverseer;

@Controller
@SessionAttributes("currentUser")
@RequestMapping("/")//Mapping deafault page as reference point
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String loginUserPage(Model model){
		UserLoginOverseer userLoginOverseer = new UserLoginOverseer();
		model.addAttribute( "userToLoginr",userLoginOverseer);

		
		return "loginPage";
	}
	
	@RequestMapping("/processLogin")
	public String processLogin(Model model,@Valid @ModelAttribute("userToLoginr")UserLoginOverseer userLoginOverseerr,BindingResult br)throws NoSuchAlgorithmException{
		if(br.hasErrors()) {
			return "loginPage";
		}
		User user = userService.getUserByLogin(userLoginOverseerr.getLogin());
		if(user == null) {
			return "loginPage";
		}
		
		if(userService.loginUser(user, userLoginOverseerr.getPassword())) {
			model.addAttribute("currentUser", user);
			return "redirect:/";
		}else {
			return "loginPage";
		}

	}
	
	@RequestMapping("/register")
	public String registerUSerPage(Model model){
		
		UserRegistrationOverseer userRegistrationOverseer = new UserRegistrationOverseer();
		model.addAttribute("userToRegister",userRegistrationOverseer);
		
		return "registrationPage";
	}
	
	@RequestMapping("/registerUser")
	public String proceedUserRegistration(Model model,@Valid @ModelAttribute("userToRegister")UserRegistrationOverseer userRegistrationOverseer, BindingResult br)throws NoSuchAlgorithmException{
		if(br.hasErrors()) {
			return "registrationPage";
		}

		
		User newUser = new User(userRegistrationOverseer.getLogin(),userRegistrationOverseer.getHashedPassword(),userRegistrationOverseer.getEmail(),null);
		//User newUser = new User();
		
		userService.saveUser(newUser);
		
		return "redirect:/";
	}

}

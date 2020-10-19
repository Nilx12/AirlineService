package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String loginUserPage(){
		return "loginPage";
	}
	
	@RequestMapping("/processLogin")
	public String processLogin(){
		return "loginPage";
	}
	
	@RequestMapping("/register")
	public String registerUSerPage(){
		return "registerPage";
	}
	
}

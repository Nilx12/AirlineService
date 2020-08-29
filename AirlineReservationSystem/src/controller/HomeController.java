package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
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
}


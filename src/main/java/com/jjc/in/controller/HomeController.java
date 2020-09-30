package com.jjc.in.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jjc")
public class HomeController {
	
	@GetMapping("/home")
	public String showHome(Model model) {
		
		return "Home";

	}
	
	@GetMapping("/aboutus")
	public String showAboutUs(Model model) {
		
		return "AboutUs";

	}
	
	@GetMapping("/contactus")
	public String showContactUs(Model model) {
		
		return "ContactUs";

	}
}

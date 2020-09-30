package com.jjc.in.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jjc.in.model.Mobile;
import com.jjc.in.service.IMobileService;

@Controller
@RequestMapping("/mobile")
public class MobileController {
	
	@Autowired
	private IMobileService service;
	
	
	
	// 1.Show Register page
	@GetMapping("/register")
	public String showReg(Model model) {
		
		model.addAttribute("mobile", new Mobile());
		return "MobileRegister";
	}
	
	//2. Save Student
	@PostMapping("/save")
	public String save(@ModelAttribute Mobile mobile, Model model) {
		
		Integer id = null;
		String message = null;
		 id = service.saveMobile(mobile);
		 
		 message = "Mobile '"+id+"' Saved Successfully";
		 
		 //for Ui
		 
		 model.addAttribute("message", message);
		 
		 model.addAttribute("mobile", new Mobile());
		 
		 return "MobileRegister";
		
	}
	
	@GetMapping("/all")
	public String fetchAll(Model model) {
		try {
			List<Mobile> list = service.getAllMobiles();
			model.addAttribute("list", list);
		}catch (Exception e){
			e.printStackTrace();
		}
			return "MobileData";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id,Model model) {
		
		String message = null;
		if(service.isMobileExist(id)) {
			service.deleteMobile(id);
			message = "Mobile With Id '"+id+"' Deleted ";
		}else {
			message = "Mobile With Id '"+id+"' Not Exist ";
		}
		model.addAttribute("message", message);
		
		//Fetch All Latest Data
		List<Mobile> list = service.getAllMobiles();
		model.addAttribute("list" , list);
		//send to Ui
		return "MobileData";
	
	}
	
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id, Model model) {
		
		String page = null;
		Optional<Mobile> opt = service.getOneMobile(id);
		
		if(opt.isPresent()) {
			
			//If exist -- goto edit page
			model.addAttribute("mobile",opt.get());
			page = "MobileEdit";
		}else {
			//given id not exist in DB
			page ="redirect:all";
		}
		return page;
	}
	
	@GetMapping("/update")
	public String update(@ModelAttribute Mobile mobile) {
		
		service.updateMobile(mobile);
		return "redirect:all";
		
	}

}



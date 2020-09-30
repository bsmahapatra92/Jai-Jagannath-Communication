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

import com.jjc.in.model.EarPhone;
import com.jjc.in.service.IEarPhoneService;

@Controller
@RequestMapping("/earphone")
public class EarPhoneController {
	@Autowired
	private IEarPhoneService service;
	
	
	
	@GetMapping("/register")
	public String showReg(Model model) {
		
		model.addAttribute("earphone", new EarPhone());
		 return "EarPhoneRegister";
		
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute EarPhone earphone, Model model) {
		
		String message = null;
		Integer id = null;
		
		id = service.saveEarPhone(earphone);
		
		message = "EarPhone Saved '"+id+"' Successfully";
		
		model.addAttribute("message", message);
		
		model.addAttribute("earphone", new EarPhone());
		
		return "EarPhoneRegister";
		
	}
	
	@GetMapping("/all")
	public String fetchAll(Model model) {
		try {
			List<EarPhone> list = service.getAllEarPhones();
			model.addAttribute("list", list);
		}catch (Exception e){
			e.printStackTrace();
		}
			return "EarPhoneData";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id,Model model) {
		
		String message = null;
		if(service.isEarPhoneExist(id)) {
			service.deleteEarPhone(id);
			message = "EarPhone With Id '"+id+"' Deleted ";
		}else {
			message = "EarPhone With Id '"+id+"' Not Exist ";
		}
		model.addAttribute("message", message);
		
		//Fetch All Latest Data
		List<EarPhone> list = service.getAllEarPhones();
		model.addAttribute("list" , list);
		
		//send to Ui
		return "EarPhoneData";
	
	}
	
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id, Model model) {
		
		String page = null;
		Optional<EarPhone> opt = service.getOneEarPhone(id);
		
		if(opt.isPresent()) {
			
			//If exist -- goto edit page
			model.addAttribute("EarPhone",opt.get());
			page = "EarPhoneEdit";
		}else {
			//given id not exist in DB
			page ="redirect:all";
		}
		return page;
	}
	
	@GetMapping("/update")
	public String update(@ModelAttribute EarPhone earPhone) {
		
		service.updateEarPhone(earPhone);
		return "redirect:all";
		
	}

}

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

import com.jjc.in.model.TemperedGlass;
import com.jjc.in.service.ITemperedGlassService;

@Controller
@RequestMapping("/temperedglass")
public class TemperedGlassController {
	
	@Autowired
	private ITemperedGlassService service;
	
	
	@GetMapping("/register")
	public String showReg(Model model) {
		
		model.addAttribute("temperedglass", new TemperedGlass());
		 return "TemperedGlassRegister";
		
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute TemperedGlass temperedglass, Model model) {
		
		String message = null;
		Integer id = null;
		
		id = service.saveTemperedGlass(temperedglass);
		
		message = "TemperedGlass Saved '"+id+"' Successfully";
		
		model.addAttribute("message", message);
		
		model.addAttribute("temperedglass", new TemperedGlass());
		
		return "TemperedGlassRegister";
		
	}
	
	@GetMapping("/all")
	public String fetchAll(Model model) {
		try {
			List<TemperedGlass> list = service.getAllTemperedGlasss();
			model.addAttribute("list", list);
		}catch (Exception e){
			e.printStackTrace();
		}
			return "TemperedGlassData";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id,Model model) {
		
		String message = null;
		if(service.isTemperedGlassExist(id)) {
			service.deleteTemperedGlass(id);
			message = "TemperedGlass With Id '"+id+"' Deleted ";
		}else {
			message = "TemperedGlass With Id '"+id+"' Not Exist ";
		}
		model.addAttribute("message", message);
		
		//Fetch All Latest Data
		List<TemperedGlass> list = service.getAllTemperedGlasss();
		model.addAttribute("list" , list);
		
		//send to Ui
		return "TemperedGlassData";
	
	}
	
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id, Model model) {
		
		String page = null;
		Optional<TemperedGlass> opt = service.getOneTemperedGlass(id);
		
		if(opt.isPresent()) {
			
			//If exist -- goto edit page
			model.addAttribute("TemperedGlass",opt.get());
			page = "TemperedGlassEdit";
		}else {
			//given id not exist in DB
			page ="redirect:all";
		}
		return page;
	}
	
	@GetMapping("/update")
	public String update(@ModelAttribute TemperedGlass temperedglass) {
		
		service.updateTemperedGlass(temperedglass);
		return "redirect:all";
		
	}

}



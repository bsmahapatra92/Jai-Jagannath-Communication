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

import com.jjc.in.model.Cover;
import com.jjc.in.service.ICoverService;

@Controller
@RequestMapping("/cover")
public class CoverController {
	
	@Autowired
	private ICoverService service;
	
	
	
	@GetMapping("/register")
	public String showReg(Model model) {
		
		model.addAttribute("cover", new Cover());
		 return "CoverRegister";
		
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Cover cover, Model model) {
		
		String message = null;
		Integer id = null;
		
		id = service.saveCover(cover);
		
		message = "Cover Saved '"+id+"' Successfully";
		
		model.addAttribute("message", message);
		
		model.addAttribute("cover", new Cover());
		
		return "CoverRegister";
		
	}
	
	@GetMapping("/all")
	public String fetchAll(Model model) {
		try {
			List<Cover> list = service.getAllCovers();
			model.addAttribute("list", list);
		}catch (Exception e){
			e.printStackTrace();
		}
			return "CoverData";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id,Model model) {
		
		String message = null;
		if(service.isCoverExist(id)) {
			service.deleteCover(id);
			message = "Cover With Id '"+id+"' Deleted ";
		}else {
			message = "Cover With Id '"+id+"' Not Exist ";
		}
		model.addAttribute("message", message);
		
		//Fetch All Latest Data
		List<Cover> list = service.getAllCovers();
		model.addAttribute("list" , list);
		//send to Ui
		return "CoverData";
	
	}
	
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id, Model model) {
		
		String page = null;
		Optional<Cover> opt = service.getOneCover(id);
		
		if(opt.isPresent()) {
			
			//If exist -- goto edit page
			model.addAttribute("cover",opt.get());
			page = "CoverEdit";
		}else {
			//given id not exist in DB
			page ="redirect:all";
		}
		return page;
	}
	
	@GetMapping("/update")
	public String update(@ModelAttribute Cover cover) {
		
		service.updateCover(cover);
		return "redirect:all";
		
	}

}


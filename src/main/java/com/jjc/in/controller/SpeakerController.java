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

import com.jjc.in.model.Speaker;
import com.jjc.in.service.ISpeakerService;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {
	
	@Autowired
	private ISpeakerService service;
	
	
	
	@GetMapping("/register")
	public String showReg(Model model) {
		
		model.addAttribute("speaker", new Speaker());
		 return "SpeakerRegister";
		
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Speaker speaker, Model model) {
		
		String message = null;
		Integer id = null;
		
		id = service.saveSpeaker(speaker);
		
		message = "Speaker Saved '"+id+"' Successfully";
		
		model.addAttribute("message", message);
		
		model.addAttribute("speaker", new Speaker());
		
		return "SpeakerRegister";
		
	}
	
	@GetMapping("/all")
	public String fetchAll(Model model) {
		try {
			List<Speaker> list = service.getAllSpeakers();
			model.addAttribute("list", list);
		}catch (Exception e){
			e.printStackTrace();
		}
			return "SpeakerData";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id,Model model) {
		
		String message = null;
		if(service.isSpeakerExist(id)) {
			service.deleteSpeaker(id);
			message = "Speaker With Id '"+id+"' Deleted ";
		}else {
			message = "Speaker With Id '"+id+"' Not Exist ";
		}
		model.addAttribute("message", message);
		
		//Fetch All Latest Data
		List<Speaker> list = service.getAllSpeakers();
		model.addAttribute("list" , list);
		//send to Ui
		return "SpeakerData";
	
	}
	
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id, Model model) {
		
		String page = null;
		Optional<Speaker> opt = service.getOneSpeaker(id);
		
		if(opt.isPresent()) {
			
			//If exist -- goto edit page
			model.addAttribute("speaker",opt.get());
			page = "SpeakerEdit";
		}else {
			//given id not exist in DB
			page ="redirect:all";
		}
		return page;
	}
	
	@GetMapping("/update")
	public String update(@ModelAttribute Speaker speaker) {
		
		service.updateSpeaker(speaker);
		return "redirect:all";
		
	}

}

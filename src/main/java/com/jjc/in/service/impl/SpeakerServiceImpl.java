package com.jjc.in.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjc.in.model.Speaker;
import com.jjc.in.repo.SpeakerRepository;
import com.jjc.in.service.ISpeakerService;

@Service
public class SpeakerServiceImpl implements ISpeakerService {

	@Autowired
	private SpeakerRepository repo;

	@Override
	public Integer saveSpeaker(Speaker s) {

		return repo.save(s).getSpkId();
	}

	@Override
	public void updateSpeaker(Speaker s) {
		repo.save(s);

	}

	@Override
	public void deleteSpeaker(Integer id) {
		
		repo.deleteById(id);

	}

	@Override
	public Optional<Speaker> getOneSpeaker(Integer id) {
		
		return repo.findById(id);
		
	}

	@Override
	public List<Speaker> getAllSpeakers() {
	
		return repo.findAll();
		
	}

	@Override
	public boolean isSpeakerExist(Integer id) {
		
		return repo.existsById(id);
	}

}

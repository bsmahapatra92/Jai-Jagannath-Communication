package com.jjc.in.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjc.in.model.Cover;
import com.jjc.in.repo.CoverRepository;
import com.jjc.in.service.ICoverService;

@Service
public class CoverServiceImpl implements ICoverService {
	@Autowired
	private CoverRepository repo;

	@Override
	public Integer saveCover(Cover c) {

		return repo.save(c).getCId();
	}

	@Override
	public void updateCover(Cover c) {
		repo.save(c);

	}

	@Override
	public void deleteCover(Integer id) {
		
		repo.deleteById(id);

	}

	@Override
	public Optional<Cover> getOneCover(Integer id) {
		
		return repo.findById(id);
		
	}

	@Override
	public List<Cover> getAllCovers() {
	
		return repo.findAll();
		
	}

	@Override
	public boolean isCoverExist(Integer id) {
		
		return repo.existsById(id);
	}

}

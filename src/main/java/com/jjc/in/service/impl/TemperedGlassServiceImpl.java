package com.jjc.in.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjc.in.model.TemperedGlass;
import com.jjc.in.repo.TemperedGlassRepository;
import com.jjc.in.service.ITemperedGlassService;

@Service
public class TemperedGlassServiceImpl implements ITemperedGlassService {
	
	@Autowired
	private TemperedGlassRepository repo;
	
	@Override
	public Integer saveTemperedGlass(TemperedGlass tg) {
		
		return repo.save(tg).getTempGlassId();
	}

	@Override
	public void updateTemperedGlass(TemperedGlass tg) {
		
		repo.save(tg);

	}

	@Override
	public void deleteTemperedGlass(Integer id) {
		
		repo.deleteById(id);

	}

	@Override
	public Optional<TemperedGlass> getOneTemperedGlass(Integer id) {
		
		return repo.findById(id);
	}

	@Override
	public List<TemperedGlass> getAllTemperedGlasss() {

		return repo.findAll();
	}

	@Override
	public boolean isTemperedGlassExist(Integer id) {
		
		return repo.existsById(id);
	}

}

package com.jjc.in.service.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjc.in.model.EarPhone;
import com.jjc.in.repo.EarPhoneRepository;
import com.jjc.in.service.IEarPhoneService;

@Service
public class EarPhoneServiceImpl implements IEarPhoneService {

	@Autowired
	private EarPhoneRepository repo;

	@Override
	public Integer saveEarPhone(EarPhone ep) {

		return repo.save(ep).getEarPhId();
	}

	@Override
	public void updateEarPhone(EarPhone ep) {
		repo.save(ep);

	}

	@Override
	public void deleteEarPhone(Integer id) {
		
		repo.deleteById(id);

	}

	@Override
	public Optional<EarPhone> getOneEarPhone(Integer id) {
		
		return repo.findById(id);
		
	}

	@Override
	public List<EarPhone> getAllEarPhones() {
	
		return repo.findAll();
		
	}

	@Override
	public boolean isEarPhoneExist(Integer id) {
		
		return repo.existsById(id);
	}

}

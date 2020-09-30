package com.jjc.in.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjc.in.model.Mobile;
import com.jjc.in.repo.MobileRepository;
import com.jjc.in.service.IMobileService;

@Service
public class MobileServiceImpl implements IMobileService {

	@Autowired
	private MobileRepository repo;

	@Override
	public Integer saveMobile(Mobile m) {
		
		 return repo.save(m).getMobId();
		 
	}

	@Override
	public void updateMobile(Mobile m) {
//		Optional<Mobile> opt = repo.findById(m.getMobId());
//		if(!opt.isPresent())
			//throw new DataNotFoundException("Mobiles '" +mobile.getMobId()+ "'");
		
		repo.save(m);

	}

	@Override
	public void deleteMobile(Integer id) {
		
		//Optional<Mobile> opt = repo.findById(id);
		//if(!opt.isPresent())
			//throw new DataNotFoundException("Mobile '" + id + "' Not Found");  
		
		repo.deleteById(id);

	}

	@Override
	public Optional<Mobile> getOneMobile(Integer id) {
		//Optional<Mobile> opt = repo.findById(id);
		//if(!opt.isPresent())
			//throw new DataNotFoundException("Mobile '" + id + "' Not Found"); 
		return repo.findById(id);
	}

	@Override
	public List<Mobile> getAllMobiles() {
		return repo.findAll();
		 
	}

	@Override
	public boolean isMobileExist(Integer id) {
		return repo.existsById(id);
		
	}

}
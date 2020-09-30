package com.jjc.in.service;

import java.util.List;
import java.util.Optional;

import com.jjc.in.model.Mobile;

public interface IMobileService {
	
	Integer saveMobile(Mobile m);
	void updateMobile(Mobile m);
	void deleteMobile(Integer id);
	Optional<Mobile> getOneMobile(Integer id);
	List<Mobile> getAllMobiles();
	boolean isMobileExist(Integer id);

}

package com.jjc.in.service;

import java.util.List;
import java.util.Optional;

import com.jjc.in.model.EarPhone;

public interface IEarPhoneService {
	
	Integer saveEarPhone(EarPhone ep);
	void updateEarPhone(EarPhone ep);
	void deleteEarPhone(Integer id);
	Optional<EarPhone> getOneEarPhone(Integer id);
	List<EarPhone> getAllEarPhones();
	boolean isEarPhoneExist(Integer id);

}

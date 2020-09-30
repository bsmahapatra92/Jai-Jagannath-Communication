package com.jjc.in.service;

import java.util.List;
import java.util.Optional;

import com.jjc.in.model.TemperedGlass;



public interface ITemperedGlassService {
	
	Integer saveTemperedGlass(TemperedGlass tg);
	void updateTemperedGlass(TemperedGlass tg);
	void deleteTemperedGlass(Integer id);
	Optional<TemperedGlass> getOneTemperedGlass(Integer id);
	List<TemperedGlass> getAllTemperedGlasss();
	boolean isTemperedGlassExist(Integer id);

}

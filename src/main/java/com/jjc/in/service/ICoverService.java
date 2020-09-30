package com.jjc.in.service;

import java.util.List;
import java.util.Optional;

import com.jjc.in.model.Cover;

public interface ICoverService {
	
	Integer saveCover(Cover c);
	void updateCover(Cover c);
	void deleteCover(Integer id);
	Optional<Cover> getOneCover(Integer id);
	List<Cover> getAllCovers();
	boolean isCoverExist(Integer id);

}

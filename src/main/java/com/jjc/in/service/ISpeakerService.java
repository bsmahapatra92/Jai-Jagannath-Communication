package com.jjc.in.service;

import java.util.List;
import java.util.Optional;


import com.jjc.in.model.Speaker;

public interface ISpeakerService {
	
	Integer saveSpeaker(Speaker s);
	void updateSpeaker(Speaker s);
	void deleteSpeaker(Integer id);
	Optional<Speaker> getOneSpeaker(Integer id);
	List<Speaker> getAllSpeakers();
	boolean isSpeakerExist(Integer id);

}

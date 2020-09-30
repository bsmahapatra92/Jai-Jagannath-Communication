package com.jjc.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjc.in.model.Speaker; 

public interface SpeakerRepository extends JpaRepository<Speaker, Integer>{

}

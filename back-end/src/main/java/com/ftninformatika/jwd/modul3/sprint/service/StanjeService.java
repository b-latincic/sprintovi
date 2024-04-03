package com.ftninformatika.jwd.modul3.sprint.service;

import java.util.List;

import com.ftninformatika.jwd.modul3.sprint.model.Stanje;

public interface StanjeService {

	List<Stanje> findAll();
	
	Stanje findOne(Long id);
	
}

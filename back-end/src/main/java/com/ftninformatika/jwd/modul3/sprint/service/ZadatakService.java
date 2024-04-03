package com.ftninformatika.jwd.modul3.sprint.service;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.modul3.sprint.model.Zadatak;

public interface ZadatakService {

	
	Page<Zadatak> find(String ime, Long sprintId, Integer pageNo);
	
	Zadatak findOne(Long id);
	
	Zadatak save(Zadatak zadatak);
	
	Zadatak update(Zadatak zadatak);
	
	Zadatak delete(Long id);
	
	Zadatak setNextStanje(Zadatak zadatak);
	
	
}

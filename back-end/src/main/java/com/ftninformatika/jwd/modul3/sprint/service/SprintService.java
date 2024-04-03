package com.ftninformatika.jwd.modul3.sprint.service;

import java.util.List;

import com.ftninformatika.jwd.modul3.sprint.model.Sprint;

public interface SprintService {

	
	List<Sprint> findAll();
	
	Sprint findOne(Long id);
	
}

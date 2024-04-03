package com.ftninformatika.jwd.modul3.sprint.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.sprint.model.Sprint;
import com.ftninformatika.jwd.modul3.sprint.model.Zadatak;
import com.ftninformatika.jwd.modul3.sprint.repository.SprintRepository;
import com.ftninformatika.jwd.modul3.sprint.service.SprintService;

@Service
public class JpaSprintService implements SprintService {

	@Autowired
	private SprintRepository sprintRepository;
	
	@Override
	public List<Sprint> findAll() {		
		
		List<Sprint> sviSprintovi = sprintRepository.findAll();
	
		
		return sprintRepository.findAll();		
	}

	@Override
	public Sprint findOne(Long id) {
		return sprintRepository.findOneById(id);
	}
	

}

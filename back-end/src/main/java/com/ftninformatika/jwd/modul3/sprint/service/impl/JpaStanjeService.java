package com.ftninformatika.jwd.modul3.sprint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.sprint.model.Stanje;
import com.ftninformatika.jwd.modul3.sprint.repository.StanjeRepository;
import com.ftninformatika.jwd.modul3.sprint.service.StanjeService;

@Service
public class JpaStanjeService implements StanjeService {

	@Autowired
	private StanjeRepository stanjeRepository;
	
	@Override
	public List<Stanje> findAll() {
		return stanjeRepository.findAll();
	}

	@Override
	public Stanje findOne(Long id) {
		
		return stanjeRepository.findOneById(id);
	}

}

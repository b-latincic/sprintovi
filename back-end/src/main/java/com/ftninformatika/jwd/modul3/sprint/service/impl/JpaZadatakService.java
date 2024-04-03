package com.ftninformatika.jwd.modul3.sprint.service.impl;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.modul3.sprint.model.Stanje;
import com.ftninformatika.jwd.modul3.sprint.model.Zadatak;
import com.ftninformatika.jwd.modul3.sprint.repository.SprintRepository;
import com.ftninformatika.jwd.modul3.sprint.repository.StanjeRepository;
import com.ftninformatika.jwd.modul3.sprint.repository.ZadatakRepository;
import com.ftninformatika.jwd.modul3.sprint.service.ZadatakService;

@Service
public class JpaZadatakService implements ZadatakService {
	
	@Autowired
	private SprintRepository sprintRepository;
	
	@Autowired
	private StanjeRepository stanjeRepository;
	
	@Autowired
	private ZadatakRepository zadatakRepository;


	@Override
	public Page<Zadatak> find(String ime, Long sprintId, Integer pageNo) {
		
		if (ime == null) {
			ime = "";
		}
		
		if(sprintId == null) {
			return zadatakRepository.findByImeContaining(ime, PageRequest.of(pageNo, 4));
		}
		 
		return zadatakRepository.findByImeContainingAndSprintId(ime, sprintId, PageRequest.of(pageNo, 4));
		
	}

	@Override
	public Zadatak findOne(Long id) {
		return zadatakRepository.findOneById(id);
	}

	@Override
	public Zadatak save(Zadatak zadatak) {
		
		zadatak.getSprint().setUkupnoBodova(zadatak.getSprint().getUkupnoBodova() + zadatak.getBodovi());
		
		return zadatakRepository.save(zadatak);
	}

	@Override
	public Zadatak update(Zadatak zadatak) {
		
		int stariBroj = zadatakRepository.findOneById(zadatak.getId()).getBodovi();
		
		
	    zadatak.getSprint().setUkupnoBodova(zadatak.getSprint().getUkupnoBodova() + (zadatak.getBodovi() - stariBroj));			
				
				
		return zadatakRepository.save(zadatak);
	}

	@Override
	public Zadatak delete(Long id) {

		Zadatak z = findOne(id);
		if(z != null) {
			z.getSprint().getZadaci().remove(z);
			z.getStanje().getZadaci().remove(z);
			z.getSprint().setUkupnoBodova(z.getSprint().getUkupnoBodova() - z.getBodovi());
			
			zadatakRepository.delete(z);
			return z;
		}
		return null;
	}

	@Override
	public Zadatak setNextStanje(Zadatak zadatak) {
		
	
		
		Long stanjeId = zadatak.getStanje().getId();

		Stanje nextStanje = stanjeRepository.findOneById(stanjeId +1);
		
		if (nextStanje == null) {
            throw new EntityNotFoundException("Next Stanje not found for Zadatak ID: " + zadatak.getId());
		}
		
		zadatak.setStanje(nextStanje);
		
		
		return zadatakRepository.save(zadatak);
	}

	
}

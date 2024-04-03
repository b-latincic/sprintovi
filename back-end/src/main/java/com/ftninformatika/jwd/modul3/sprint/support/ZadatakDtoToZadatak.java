package com.ftninformatika.jwd.modul3.sprint.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.sprint.model.Zadatak;
import com.ftninformatika.jwd.modul3.sprint.service.SprintService;
import com.ftninformatika.jwd.modul3.sprint.service.StanjeService;
import com.ftninformatika.jwd.modul3.sprint.service.ZadatakService;
import com.ftninformatika.jwd.modul3.sprint.web.dto.ZadatakDTO;

@Component
public class ZadatakDtoToZadatak implements Converter<ZadatakDTO, Zadatak> {

	@Autowired
	private ZadatakService zadatakService;
	
	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private StanjeService stanjeService;
	
	
	@Override
	public Zadatak convert(ZadatakDTO dto) {
		
		Zadatak zadatak = new Zadatak();
	
		
			zadatak.setBodovi(dto.getBodovi());
			zadatak.setId(dto.getId());
			zadatak.setIme(dto.getIme());
			zadatak.setSprint(sprintService.findOne(dto.getSprintId()));
			zadatak.setStanje(stanjeService.findOne(dto.getStanjeId()));
			zadatak.setZaduzeni(dto.getZaduzeni());
				
		
		return zadatak;
	}

	
	
	
}

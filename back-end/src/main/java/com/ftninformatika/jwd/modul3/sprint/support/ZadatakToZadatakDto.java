package com.ftninformatika.jwd.modul3.sprint.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.sprint.model.Zadatak;
import com.ftninformatika.jwd.modul3.sprint.web.dto.ZadatakDTO;

@Component
public class ZadatakToZadatakDto implements Converter<Zadatak, ZadatakDTO> {

	
	
	@Override
	public ZadatakDTO convert(Zadatak zadatak) {

		ZadatakDTO dto = new ZadatakDTO();

		dto.setId(zadatak.getId());
		dto.setIme(zadatak.getIme());
		dto.setBodovi(zadatak.getBodovi());
		dto.setZaduzeni(zadatak.getZaduzeni());
		
		dto.setStanjeId(zadatak.getStanje().getId());
		dto.setSprintId(zadatak.getSprint().getId());
		
		dto.setSprintIme(zadatak.getSprint().getIme());
		dto.setStanjeIme(zadatak.getStanje().getIme());
		
		
		return dto;
	}


	public List<ZadatakDTO> convert(List<Zadatak> zadaci) {
		
		List<ZadatakDTO> zadaciDto = new ArrayList<>();
		
		for(Zadatak zadatak: zadaci) {
			zadaciDto.add(convert(zadatak));
		}
		return zadaciDto;
	}
	
	

}

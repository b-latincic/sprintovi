package com.ftninformatika.jwd.modul3.sprint.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.modul3.sprint.model.Sprint;
import com.ftninformatika.jwd.modul3.sprint.web.dto.SprintDTO;

@Component
public class SprintToSprintDto implements Converter<Sprint, SprintDTO> {

	@Override
	public SprintDTO convert(Sprint sprint) {
		
		SprintDTO dto = new SprintDTO();
		
		dto.setId(sprint.getId());
		dto.setIme(sprint.getIme());
		dto.setUkupnoBodova(sprint.getUkupnoBodova());
		return dto;
	}
	
	public List<SprintDTO> convert(List<Sprint> sprintovi) {
		List<SprintDTO> sprintoviDto = new ArrayList<>();
		
		for(Sprint sprint: sprintovi) {
			sprintoviDto.add(convert(sprint));
		}
		return sprintoviDto;
	}
}

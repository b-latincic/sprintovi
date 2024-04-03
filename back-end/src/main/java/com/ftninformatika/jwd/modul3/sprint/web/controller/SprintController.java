package com.ftninformatika.jwd.modul3.sprint.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.sprint.model.Sprint;
import com.ftninformatika.jwd.modul3.sprint.service.SprintService;
import com.ftninformatika.jwd.modul3.sprint.support.SprintToSprintDto;
import com.ftninformatika.jwd.modul3.sprint.web.dto.SprintDTO;

@RestController
@RequestMapping(value="/api/sprintovi", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class SprintController {
	
	@Autowired
	private SprintService sprintService;
	
	@Autowired
	private SprintToSprintDto toSprintDto;


	@GetMapping
	public ResponseEntity<List<SprintDTO>> getAll(
			@RequestParam(required=false) Long id,
			@RequestParam(required=false) String naziv,
			@RequestParam(required=false) Integer ukupnoBodova
			) {
		
		List<Sprint> sprintovi = sprintService.findAll();
		
		return new ResponseEntity<>(toSprintDto.convert(sprintovi), HttpStatus.OK);
	}
	

}

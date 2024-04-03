package com.ftninformatika.jwd.modul3.sprint.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.sprint.model.Stanje;
import com.ftninformatika.jwd.modul3.sprint.service.StanjeService;
import com.ftninformatika.jwd.modul3.sprint.support.StanjeToStanjeDto;
import com.ftninformatika.jwd.modul3.sprint.web.dto.StanjeDTO;

@RestController
@RequestMapping(value="/api/stanja", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class StanjeController {

	@Autowired
	private StanjeService stanjeService;
	
	@Autowired
	private StanjeToStanjeDto toStanjeDto;
	
	@GetMapping
	public ResponseEntity<List<StanjeDTO>> getAll(
			@RequestParam(required=false) Long id,
			@RequestParam(required=false) String ime) {
		
		List<Stanje> stanja = stanjeService.findAll();
				
		return new ResponseEntity<>(toStanjeDto.convert(stanja), HttpStatus.OK);
	}
	
	
}

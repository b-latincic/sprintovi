package com.ftninformatika.jwd.modul3.sprint.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.modul3.sprint.model.Zadatak;
import com.ftninformatika.jwd.modul3.sprint.service.ZadatakService;
import com.ftninformatika.jwd.modul3.sprint.support.ZadatakDtoToZadatak;
import com.ftninformatika.jwd.modul3.sprint.support.ZadatakToZadatakDto;
import com.ftninformatika.jwd.modul3.sprint.web.dto.ZadatakDTO;

@RestController
@RequestMapping(value="/api/zadaci", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZadaciController {
	
	
	@Autowired
	private ZadatakService zadatakService;
	
	@Autowired
	private ZadatakToZadatakDto toZadatakDto;
	
	@Autowired
	private ZadatakDtoToZadatak toZadatak;
	
	@GetMapping
	public ResponseEntity<List<ZadatakDTO>> getAll(
			@RequestParam (required=false) String ime,
			@RequestParam(required=false) Long sprintId,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
		
			Page<Zadatak> page= zadatakService.find(ime, sprintId, pageNo);
			
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

	        return new ResponseEntity<>(toZadatakDto.convert(page.getContent()), headers, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ZadatakDTO> getOne(@PathVariable Long id) {
		
		Zadatak zadatak = zadatakService.findOne(id);
		
		if(zadatak != null) {
			return new ResponseEntity<>(toZadatakDto.convert(zadatak), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}			
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ZadatakDTO> create(@Valid @RequestBody ZadatakDTO zadatakDto) {
		
		Zadatak zadatak = toZadatak.convert(zadatakDto);
		Zadatak sacuvaniZadatak = zadatakService.save(zadatak);
		
		return new ResponseEntity<>(toZadatakDto.convert(sacuvaniZadatak), HttpStatus.CREATED);
	}
	
	

	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ZadatakDTO> update(@PathVariable Long id, @RequestBody ZadatakDTO zadatakDto) {
		
		if(!id.equals(zadatakDto.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} 
		
		Zadatak zadatak = toZadatak.convert(zadatakDto);
		Zadatak sacuvaniZadatak = zadatakService.update(zadatak);
		
		return new ResponseEntity<>(toZadatakDto.convert(sacuvaniZadatak), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Zadatak obrisaniZadatak = zadatakService.delete(id);
		
		HttpStatus httpStatus;
		
		if(obrisaniZadatak != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			httpStatus = HttpStatus.NOT_FOUND;
		}
		  
		System.out.println("Status code: " + httpStatus.value());
	    return new ResponseEntity<>(httpStatus);
	}
	
	@PutMapping("/{id}/next")
	public ResponseEntity<ZadatakDTO> update(@PathVariable Long id) {
		
		Zadatak zadatak = zadatakService.findOne(id);
		
		if (zadatak == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Zadatak updatedZadatak = zadatakService.setNextStanje(zadatak);
		
		return new ResponseEntity<>(toZadatakDto.convert(updatedZadatak), HttpStatus.OK);
		
		
	}
	
	
	

}

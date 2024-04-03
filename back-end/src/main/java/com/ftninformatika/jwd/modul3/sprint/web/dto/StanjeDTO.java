package com.ftninformatika.jwd.modul3.sprint.web.dto;

import java.util.Objects;

import javax.validation.constraints.Positive;

public class StanjeDTO {

    @Positive(message = "Id mora biti pozitivan broj.")
	private Long id;
	
	
	private String ime;


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	public StanjeDTO() {
		super();
	}

	
	
	

	public StanjeDTO(String ime) {
		super();
		this.ime = ime;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StanjeDTO other = (StanjeDTO) obj;
		return Objects.equals(id, other.id);
	}


	
	
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	} 
	
	
	
	
}

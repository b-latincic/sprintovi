package com.ftninformatika.jwd.modul3.sprint.web.dto;

import javax.validation.constraints.Positive;

public class SprintDTO {
	
    @Positive(message = "Id mora biti pozitivan broj.")
	private Long id;
	
	private String ime;
	
	private int ukupnoBodova;

	public SprintDTO() {
		super();
	}
	
	

	public SprintDTO(String ime) {
		super();
		this.ime = ime;
	}



	public Long getId() {
		return id;
	}

	public SprintDTO(String ime, int ukupnoBodova) {
		super();
		this.ime = ime;
		this.ukupnoBodova = ukupnoBodova;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public SprintDTO(@Positive(message = "Id mora biti pozitivan broj.") Long id, String ime, int ukupnoBodova) {
		super();
		this.id = id;
		this.ime = ime;
		this.ukupnoBodova = ukupnoBodova;
	}

	public int getUkupnoBodova() {
		return ukupnoBodova;
	}

	public void setUkupnoBodova(int ukupnoBodova) {
		this.ukupnoBodova = ukupnoBodova;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	
	

}

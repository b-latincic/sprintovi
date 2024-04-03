package com.ftninformatika.jwd.modul3.sprint.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ZadatakDTO {

    @Positive(message = "Id mora biti pozitivan broj.")
	private Long id;
	
	@NotBlank(message="Ime mora biti uneto")
	private String ime;
	
	
	private String zaduzeni;
	

    @Positive(message = "Broj bodova nije pozitivan broj.")
	private int bodovi;
	
    private Long sprintId;
    
    private Long stanjeId;
    
    private String stanjeIme;
    
    private String sprintIme;

	



	public Long getSprintId() {
		return sprintId;
	}


	public void setSprintId(Long sprintId) {
		this.sprintId = sprintId;
	}


	public Long getStanjeId() {
		return stanjeId;
	}


	public void setStanjeId(Long stanjeId) {
		this.stanjeId = stanjeId;
	}


	public String getStanjeIme() {
		return stanjeIme;
	}


	public void setStanjeIme(String stanjeIme) {
		this.stanjeIme = stanjeIme;
	}


	public String getSprintIme() {
		return sprintIme;
	}


	public void setSprintIme(String sprintIme) {
		this.sprintIme = sprintIme;
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


	public String getZaduzeni() {
		return zaduzeni;
	}


	public void setZaduzeni(String zaduzeni) {
		this.zaduzeni = zaduzeni;
	}


	public int getBodovi() {
		return bodovi;
	}


	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}




	public ZadatakDTO() {
		super();
	}





	
	
	
	
}

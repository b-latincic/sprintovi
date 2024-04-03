package com.ftninformatika.jwd.modul3.sprint.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

@Entity
public class Zadatak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	@Length(max=40)
	private String ime;
	
	@Column(nullable=false)
	private String zaduzeni;
	
	@Column
	@Min(0)
	@Max(40)
	private int bodovi;
	
	@ManyToOne
	private Sprint sprint;
	
	@ManyToOne
	private Stanje stanje;
	
	

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

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}

	public Zadatak() {
		super();
	}

	public Zadatak(String ime, String zaduzeni, int bodovi, Sprint sprint, Stanje stanje) {
		super();
		this.ime = ime;
		this.zaduzeni = zaduzeni;
		this.bodovi = bodovi;
		this.sprint = sprint;
		this.stanje = stanje;
	}

	public Zadatak(Long id, String ime, String zaduzeni, int bodovi, Sprint sprint, Stanje stanje) {
		super();
		this.id = id;
		this.ime = ime;
		this.zaduzeni = zaduzeni;
		this.bodovi = bodovi;
		this.sprint = sprint;
		this.stanje = stanje;
	}

	@Override
	public String toString() {
		return "Zadatak [id=" + id + ", ime=" + ime + ", zaduzeni=" + zaduzeni + ", bodovi=" + bodovi + ", sprint="
				+ sprint.getIme() + ", stanje=" + stanje.getIme() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zadatak other = (Zadatak) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}

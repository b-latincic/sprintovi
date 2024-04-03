package com.ftninformatika.jwd.modul3.sprint.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sprint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String ime;
	
	@Column
	private Integer ukupnoBodova;
	
	@OneToMany(mappedBy="sprint", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Zadatak> zadaci = new ArrayList<>();

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

	public int getUkupnoBodova() {
		return ukupnoBodova;
	}


	public void setUkupnoBodova(Integer ukupnoBodova) {
		this.ukupnoBodova = ukupnoBodova;
	}

	public List<Zadatak> getZadaci() {
		return zadaci;
	}

	public void setZadaci(List<Zadatak> zadaci) {
		this.zadaci = zadaci;
	}

	public Sprint() {
		super();
	}

	public Sprint(String ime, int ukupnoBodova, List<Zadatak> zadaci) {
		super();
		this.ime = ime;
		this.ukupnoBodova = ukupnoBodova;
		this.zadaci = zadaci;
	}

	public Sprint(Long id, String ime, int ukupnoBodova, List<Zadatak> zadaci) {
		super();
		this.id = id;
		this.ime = ime;
		this.ukupnoBodova = ukupnoBodova;
		this.zadaci = zadaci;
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
		Sprint other = (Sprint) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}

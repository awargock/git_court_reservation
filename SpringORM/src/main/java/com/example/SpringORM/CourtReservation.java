package com.example.SpringORM;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourtReservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String termin;
	private int nr_kortu;
	
	public CourtReservation() {
	}

	public CourtReservation(String termin, int nr_kortu) {
		this.termin = termin;
		this.nr_kortu = nr_kortu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
		this.termin = termin;
	}

	public int getNr_kortu() {
		return nr_kortu;
	}

	public void setNr_kortu(int nr_kortu) {
		this.nr_kortu = nr_kortu;
	}
	
	
}

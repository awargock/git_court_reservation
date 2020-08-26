package com.example.SpringORM;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Court {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int nr_kortu;
	private String rodzaj_nawierzchni;
	
	public Court() {
	}
	
	public Court(int nr_kortu, String rodzaj_nawierzchni) {
		this.nr_kortu = nr_kortu;
		this.rodzaj_nawierzchni = rodzaj_nawierzchni;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNr_kortu() {
		return nr_kortu;
	}
	public void setNr_kortu(int nr_kortu) {
		this.nr_kortu = nr_kortu;
	}
	public String getRodzaj_nawierzchni() {
		return rodzaj_nawierzchni;
	}
	public void setRodzaj_nawierzchni(String rodzaj_nawierzchni) {
		this.rodzaj_nawierzchni = rodzaj_nawierzchni;
	}
	
	
}

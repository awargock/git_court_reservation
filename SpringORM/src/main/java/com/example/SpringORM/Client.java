package com.example.SpringORM;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String login;
	private String pass;
	private int nr_tel;
	
	public Client(String name, String login, String pass, int nr_tel) {
		this.name = name;
		this.login = login;
		this.pass = pass;
		this.nr_tel = nr_tel;
	}
	public Client(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getNr_tel() {
		return nr_tel;
	}
	public void setNr_tel(int nr_tel) {
		this.nr_tel = nr_tel;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", login=" + login + ", pass=" + pass + ", nr_tel=" + nr_tel
				+ "]";
	}
	
}

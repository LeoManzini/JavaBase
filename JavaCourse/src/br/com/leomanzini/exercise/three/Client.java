package br.com.leomanzini.exercise.three;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private String name;
	private String email;
	private Date birthDate;
	
	public Client() {
	}
	
	public Client(String name, String email, Date birthDate) {
		setName(name);
		setEmail(email);
		setBirthDate(birthDate);
	}
	
	public String getName() {
		return this.name;
	} 
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getBirthDate() {
		return this.birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return name + " (" + sdf.format(birthDate) + ") - " + email;
 	}
}

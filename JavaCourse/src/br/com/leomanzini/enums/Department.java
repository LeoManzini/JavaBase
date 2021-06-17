package br.com.leomanzini.enums;

public class Department {
	private String name;
	
	public Department() {
	}
	
	public Department(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

package br.com.leomanzini.lists.exercises;

public class Employees {
	private Integer id;
	private String name;
	private Double salary;
	
	public Employees() {
	}

	public Employees(Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public void increaseSalary(double percentage) {
		percentage /= 100;
		this.salary += (this.salary * percentage);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return id + ", " + name + ", " + salary;
	}
}

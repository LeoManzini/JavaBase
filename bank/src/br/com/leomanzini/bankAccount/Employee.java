package br.com.leomanzini.bankAccount;

public class Employee 
{
	private String name;
	private String cpf;
	private double salary;
	
	public Employee(String name, String cpf, double salary)
	{
		this.name = name;
		this.cpf = cpf;
		this.salary = salary;
	}
	
	public void salaryIncrease(double percentage)
	{
		percentage /= 100;
		this.salary += (this.salary * percentage);
	}
	
	public String getName() 
	{
		return name;
	}
	public String getCpf() 
	{
		return cpf;
	}
	public double getSalary() 
	{
		return salary;
	}	
}

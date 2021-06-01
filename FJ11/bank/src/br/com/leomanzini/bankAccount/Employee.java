package br.com.leomanzini.bankAccount;

public abstract class Employee 
{
	private String name;
	private String cpf;
	protected double salary;
	
	public Employee(String name, String cpf, double salary)
	{
		this.name = name;
		this.cpf = cpf;
		this.salary = salary;
	}
	
	public abstract void salaryIncrease(double percentage);
	public abstract void bonus();
	
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

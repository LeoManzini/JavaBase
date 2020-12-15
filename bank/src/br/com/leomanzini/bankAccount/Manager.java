package br.com.leomanzini.bankAccount;

public class Manager extends Employee 
{
	private int password;
	private int numberOfEmployees;

	public Manager(String name, String cpf, double salary, int password) 
	{
		super(name, cpf, salary);
		this.password = password;
	}
	
	public boolean authenticates(int password)
	{
		if(this.password == password)
		{
			return true;
		} else {
			return false;
		}
	}
	
	public void changePassword(String cpf, int newPassword)
	{
		if(this.getCpf() == cpf)
		{
			this.password = newPassword;
			System.out.println("Password changed.");
		} else {
			System.out.println("Wrong CPF, can't change password.");
		}
	}

	public int getPassword() 
	{
		return password;
	}

	public int getNumberOfEmployees() 
	{
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) 
	{
		this.numberOfEmployees = numberOfEmployees;
	}
}

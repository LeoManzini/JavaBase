package br.com.leomanzini.bankAccount;

public class Manager extends Employee implements Authenticable
{
	private String password;

	public Manager(String name, String cpf, double salary, String password) 
	{
		super(name, cpf, salary);
		setPassword(password);
	}
	
	@Override
	public boolean authenticate(String password) 
	{	
		if (this.password == password) 
		{
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean passwordIntegrity(String password) 
	{
		int number = 0;
		boolean returnNumber = false;
		int uppercaseLetter = 0;
		boolean returnLetter = false;
		
		if (password.length() >= 8) 
		{
			for (int i = 0; i <= password.length(); i++)
			{
				if(password.charAt(i) >= 65 && password.charAt(i) <= 90)
				{
					uppercaseLetter++;
				}
				if(password.charAt(i) >= 48 && password.charAt(i) <= 57)
				{
					number++;
				}
			}
			
			returnNumber = (number > 0) ? true : false;
			returnLetter = (uppercaseLetter > 0) ? true : false;
			
			if(returnNumber && returnLetter)
			{
				System.out.println("Valid password!");
				return true;
			} else {
				System.out.println("Invalid password!");
				return false;
			}
			
		} else {
			System.out.println("Invalid password!");
			return false;
		}
	}

	@Override
	public boolean validateCPF(String cpf) 
	{
		if(this.getCpf() == cpf)
		{
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void changePassword(String cpf, String oldPassword, String newPassword)
	{
		if(validateCPF(cpf) && authenticate(oldPassword))
		{
			setPassword(newPassword);
			System.out.println("Password changed.");
		} else {
			System.out.println("Wrong CPF, can't change password.");
		}
	}
	
	@Override
	public void printPassword(String cpf) 
	{
		if(validateCPF(cpf))
		{
			System.out.println(getPassword());
		} else {
			System.out.println("Impossible to show password...");
		}
	}
	
	@Override
	public void salaryIncrease(double percentage)
	{
		percentage /= 100;
		this.salary += (this.salary * percentage);
	}
	
	@Override
	public void bonus()
	{
		this.salary += (this.salary * 0.75);
	}

	private String getPassword() 
	{
		return password;
	}
	
	private void setPassword(String password)
	{
		this.password = password;
	}
}

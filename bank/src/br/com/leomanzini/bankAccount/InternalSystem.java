package br.com.leomanzini.bankAccount;

public class InternalSystem 
{
	
	public InternalSystem (Authenticable people, String password) 
	{
		if(login(people, password))
		{
			System.out.println("System login completed...");
		} else {
			System.out.println("System login failed...");
		}
	}
	
	public boolean login (Authenticable people, String password) 
	{
		boolean success = people.authenticate(password);
		
		if(success)
		{
			return true;
		} else {
			return false;
		}
	}
}

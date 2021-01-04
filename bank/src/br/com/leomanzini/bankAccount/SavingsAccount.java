package br.com.leomanzini.bankAccount;

public class SavingsAccount extends Account{
	
	private String type = "Savings Account";

	public SavingsAccount(double funds) {
		super(funds);
		// TODO Auto-generated constructor stub
	}
	
	public String getType()
	{
		return this.type;
	}
}

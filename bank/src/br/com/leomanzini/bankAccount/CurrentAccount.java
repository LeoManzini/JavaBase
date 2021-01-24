package br.com.leomanzini.bankAccount;

public class CurrentAccount extends Account{
	
	private String type = "Current Account";

	public CurrentAccount(double funds) {
		super(funds, "Current Account");
	}

	@Override
	public String getType()
	{
		return this.type;
	}

	@Override
	public void changeType() 
	{
		this.type = "Savings Account";
	}
}

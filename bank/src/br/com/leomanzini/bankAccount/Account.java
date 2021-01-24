package br.com.leomanzini.bankAccount;

import java.util.Random;

/**
 * This class create a new Bank Account to the bank Leo's Bank.
 * 
 * @author LeoManzini
 *
 */

public abstract class Account 
{
    private String holder;
    private int number;
    private String agency = "0001";
    private double funds;
    private Date openingDate; 
    protected String type;
    private Random rand = new Random();
    private static int numberOfAccounts;
    private static int numberOfCurrentAccounts;
    private static int numberOfSavingsAccounts;

    /**
     * Constructor receive only the account start funds, create a number to the account 
     * and increase by one the total of accounts created.  
     * 
     * @param funds
     */
    public Account(double funds)
    {
        this.number = rand.nextInt(9999);
        this.funds = funds;
        numberOfAccounts++;
    }

    /**
     * Standard constructor to this class
     * @param funds
     * @param type
     */
    public Account(double funds, String type)
    {
        this(funds);
        setType(type);
    }
    
    /**
     * Withdraw an amount of money, if it's possible.
     * 
     * @param amount
     * @return true for success and false if you don't have enough funds.
     */
	public boolean withdraw(double amount)
    {
        if(this.funds < amount)
        {
            System.out.println("Insufficient funds.");
            return false;
        }
        else
        {
            this.funds -= amount;
            System.out.println("Withdraw sucessful.");
            return true;
        }
    }

	/**
	 * Increase your total account funds, by the amount
	 * 
	 * @param amount
	 */
    public void deposit(double amount)
    {
        this.funds += amount;
    }

    /**
     * If you have funds, deposit the amount at the account received, and withdraw of your funds.
     * 
     * @param account
     * @param amount
     */
    public void transferTo(Account account, double amount)
    {
        if(withdraw(amount))
        {
            account.funds += amount;
            System.out.println("Transference sucessful.");
        }
        else
        {
            System.out.println("Insufficient funds.");
        }
    }

    /**
     * return your monthly dividend yield, calculates with your funds and yield percentage.
     * 
     * @param yield
     * @return
     */
    public double monthlyDividendYield(double yield)
    {
        yield /= 100;
        return (yield * this.funds) / 12;
    }
    
    public abstract void changeType();

    /**
     * ToString method.
     * 
     * @return
     */
    @Override
	public String toString() {
		return "Account Holder: " + this.holder + 
			   "\nAccount number: " + this.number + 
			   "\nAgency number: " + this.agency +
			   "\nTotal funds: " + this.funds +
			   "\nOpening date: " + this.openingDate.formatedDate() + 
			   "\nMonthly yeld: " + this.monthlyDividendYield(6) +
			   "\nAccount Type: " + this.getType();
	}

	/**
     * Total of accounts created using the class.
     * 
     * @return
     */
    public static int getNumberOfAccounts()
    {
        return numberOfAccounts;
    }

    public static int getNumberOfCurrentAccounts()
    {
        return numberOfCurrentAccounts;
    }
    
    public static int getNumberOfSavingsAccounts()
    {
        return numberOfSavingsAccounts;
    }
    
    public String getHolder()
    {
        return this.holder;
    }

    public void setHolder(String holder)
    {
        this.holder = holder;
    }

    public int getNumber()
    {
        return this.number;
    }

    public String getAgency()
    {
        return this.agency;
    }

    public double getFunds()
    {
        return this.funds;
    }

    public Date getOpeningDate()
    {
        return this.openingDate;
    }

    public void setOpeningDate(Date date)
    {
        this.openingDate = date;
    }
    
    public abstract String getType();
    
    private void setType(String type) 
    {
    	if(type == "Current Account" || type == "Current account" || type == "current account") 
        {
        	this.type = "Current Account";
        } else {
        	this.type = "Savings Account";
        }
    }
}

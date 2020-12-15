package br.com.leomanzini.bankAccount;

import java.util.Random;

/**
 * This class create a new Bank Account to the bank Leo's Bank.
 * 
 * @author LeoManzini
 *
 */

public class Bank 
{
    private String holder;
    private int number;
    private String agency = "0001";
    private double funds;
    private Date openingDate; 
    private Random rand = new Random();
    private static int numberOfAccounts;

    /**
     * Constructor receive only the account start funds, create a number to the account 
     * and increase by one the total of accounts created.  
     * 
     * @param funds
     */
    public Bank(double funds)
    {
        this.number = rand.nextInt(9999);
        this.funds = funds;
        numberOfAccounts++;
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
    public void transferTo(Bank account, double amount)
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

    /**
     * Future ToString method.
     * 
     * @return
     */
    public String printData()
    {
        String data = "Holder: " + this.holder;
        data += "\nAccount number: " + this.number;
        data += "\nAgency number: " + this.agency;
        data += "\nTotal funds: " + this.funds;
        data += "\nOpening date: " + this.openingDate.formatedDate();
        data += "\nMonthly yeld: " + this.monthlyDividendYield(6);

        return data;
    }
    
    /**
     * Total of accouts created using the class.
     * 
     * @return
     */
    public static int getNumberOfAccounts()
    {
        return numberOfAccounts;
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
}

package bank;

import java.util.Random;

class Date
{
    private int mounth;
    private int day;
    private int year;

    public Date(int day, int mounth, int year)
    {
        this.day = day;
        this.mounth = mounth;
        this.year = year;
    }

    public String formatedDate() 
    {
        String newDate = this.day + "/";
        newDate += this.mounth + "/";
        newDate += this.year;

        return newDate;
    }

    public int getDay() 
    {
        return day;
    }

    public int getMounth() 
    {
        return mounth;
    }
    
    public int getYear() 
    {
        return year;
    }
}

public class BankAccount 
{
    private String holder;
    private int number;
    private String agency = "0001";
    private double funds;
    private Date openingDate; 
    private Random rand = new Random();

    public BankAccount(double funds)
    {
        this.number = rand.nextInt(9999);
        this.funds = funds;
    }

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

    public void deposit(double amount)
    {
        this.funds += amount;
    }

    public void transferTo(BankAccount account, double amount)
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

    public double monthlyDividendYield(double yield)
    {
        yield /= 100;
        return (yield * this.funds) / 12;
    }

    public String printData()
    {
        String data = "Holder: " + this.holder;
        data += "\nAccount number: " + this.number;
        data += "\nAgency number: " + this.agency;
        data += "\nTotal funds: " + this.funds;
        data += "\nOpening date: " + this.openingDate.formatedDate();
        data += "\nMonthly yeld; " + this.monthlyDividendYield(6);

        return data;
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

    public void setOpeningDate(int day, int mounth, int year)
    {
        this.openingDate = new Date (day, mounth, year);
    }
}

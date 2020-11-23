package bank;

class Date
{
    String day;
    String mounth;
    String year;

    String formatedDate() 
    {
        String newDate = this.day + "/";
        newDate += this.mounth + "/";
        newDate += this.year;

        return newDate;
    }
}

public class BankAccount 
{
    String holder;
    int number;
    String agency;
    double funds;
    Date openingDate; 
    
    boolean withdraw(double amount)
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

    void deposit(double amount)
    {
        this.funds += amount;
    }

    void transferTo(BankAccount account, double amount)
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

    double monthlyDividendYield(double yield)
    {
        yield /= 100;
        return (yield * this.funds) / 12;
    }

    String printData()
    {
        String data = "Holder: " + this.holder;
        data += "\nAccount number: " + this.number;
        data += "\nAgency number: " + this.agency;
        data += "\nTotal funds: " + this.funds;
        data += "\nOpening date: " + this.openingDate.formatedDate();
        data += "\nMonthly yeld; " + this.monthlyDividendYield(6);

        return data;
    }
}

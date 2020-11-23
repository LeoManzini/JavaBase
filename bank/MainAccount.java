package bank;

public class MainAccount 
{
    public static void main(String args[])
    {
        BankAccount mineAccount = new BankAccount();
        Date openingAccount = new Date();
        mineAccount.openingDate = openingAccount;

        mineAccount.agency = "0001";
        mineAccount.funds = 15000.0;
        mineAccount.holder = "Leonardo";
        mineAccount.number = 1234;
        mineAccount.openingDate.day = "23";
        mineAccount.openingDate.mounth = "11";
        mineAccount.openingDate.year = "2020";

        mineAccount.deposit(100);
        String data = mineAccount.printData();
        
        System.out.println(data);
    }
}

package src.br.com.leomanzini.samples;

public class BalanceSheet 
{
    public static void main(String args[]) 
    {

        // Declaring the variables
        int januarySpendings = 15000;
        int februarySpendings = 23000;
        int marchSpendings = 17000;

        // Processing data
        int quarterExpenses = januarySpendings + februarySpendings + marchSpendings;
        float monthlyAverage = quarterExpenses / 3;

        // Printing the result
        System.out.println("Total spent at this quarter: $" + quarterExpenses);
        System.out.println("Monthly average: $" + monthlyAverage);
    }
}

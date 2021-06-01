package br.com.leomanzini.bankAccount;

/**
 * This class create a personal class Date.
 * 
 * @author LeoManzini
 *
 */

public class Date
{
    private int mounth;
    private int day;
    private int year;

    /**
     * Constructor that receive the data.
     * 
     * @param day
     * @param mounth
     * @param year
     */
    public Date(int day, int mounth, int year)
    {
        this.day = day;
        this.mounth = mounth;
        this.year = year;
    }

    /**
     * Format the date to show to the user.
     * 
     * @return the date formated.
     */
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

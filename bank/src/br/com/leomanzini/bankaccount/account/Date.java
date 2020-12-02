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

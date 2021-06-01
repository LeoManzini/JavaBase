package br.com.leomanzini.challenges;

public class RecursiveFibonacci 
{
    public int calculateFibonacci(int value)
    {   
        if (value < 2) { 
            return value;
            }
        return calculateFibonacci(value - 1) + calculateFibonacci(value - 2);
    }
}

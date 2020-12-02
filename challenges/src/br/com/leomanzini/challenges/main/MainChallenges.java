package br.com.leomanzini.challenges.main;

import challenges.RecursiveFatorial;
import challenges.RecursiveFibonacci;

public class MainChallenges 
{
    public static void main(String args[])
    {
        // Testing recursive Fibonacci
        RecursiveFibonacci fibonacci = new RecursiveFibonacci();

        System.out.print("Fibonacci sequence: ");
        for(int i = 0; i <= 10; i++)
        {
            System.out.print(fibonacci.calculateFibonacci(i) + " ");
        }
        System.out.println();

        // Testing recursive Fatorial
        RecursiveFatorial fatorial = new RecursiveFatorial();
        System.out.println("!4 = " + fatorial.calculatefatorial(4));
    }    
}

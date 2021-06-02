package br.com.leomanzini.exercise.one;

import java.util.Scanner;

public class Difference {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter with four numbers to calculate the difference: ");
		int firstNumber = sc.nextInt();
		int secondNumber = sc.nextInt();
		int thirdNumber = sc.nextInt();
		int fourthNumber = sc.nextInt();
		
		int difference = (firstNumber * secondNumber - thirdNumber * fourthNumber);
		
		System.out.println("The difference is: " + difference);
		
		sc.close();
	}
}

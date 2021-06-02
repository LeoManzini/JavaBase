package br.com.leomanzini.exercise.one;

import java.util.Scanner;

public class SumExercise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter with two integer numbers to sum: ");
		int firstNumber = sc.nextInt();
		int secondNumber = sc.nextInt();
		
		System.out.printf("%d + %d = %d", firstNumber, secondNumber, firstNumber + secondNumber);
		
		sc.close();
	}
}

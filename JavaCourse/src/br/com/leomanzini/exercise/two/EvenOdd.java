package br.com.leomanzini.exercise.two;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter with a integer number: ");
		int number = sc.nextInt();
		
		if (number % 2 != 0) {
			System.out.println("The number is odd!!");
		} else {
			System.out.println("The number is even!!");
		}
		
		sc.close();
	}
}

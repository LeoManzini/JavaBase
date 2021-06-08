package br.com.leomanzini.exercise.two;

import java.util.Scanner;

public class NegativeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter with a integer number: ");
		int number = sc.nextInt();
		
		if(number >= 0) {
			System.out.println("Positive number!!");
		} else {
			System.out.println("Negative number!!");
		}
		
		sc.close();
	}
}

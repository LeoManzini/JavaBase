package br.com.leomanzini.exercise.two;

import java.util.Scanner;

public class Multiples {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter with two integer numbers: ");
		int numberOne = sc.nextInt();
		int numberTwo = sc.nextInt();
		
		if(numberOne % numberTwo == 0 || numberTwo % numberOne == 0) {
			System.out.println("The numbers are multiples!!");
		} else {
			System.out.println("The numbers are not multiples!!");
		}
		
		sc.close();
	}
}

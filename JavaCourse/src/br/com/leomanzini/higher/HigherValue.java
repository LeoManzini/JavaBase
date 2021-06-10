package br.com.leomanzini.higher;

import java.util.Scanner;

public class HigherValue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter with three numbers: ");
		int numberOne = sc.nextInt();
		int numberTwo = sc.nextInt();
		int numberThree = sc.nextInt();
		
		if (numberOne > numberTwo && numberOne > numberThree) {
			System.out.println("The higher number is: " + numberOne);
		} else if(numberTwo > numberThree) {
			System.out.println("The higher number is: " + numberTwo);
		} else {
			System.out.println("The higher number is: " + numberThree);
		}
		
		sc.close();
	}
}

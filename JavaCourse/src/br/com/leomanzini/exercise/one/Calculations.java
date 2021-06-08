package br.com.leomanzini.exercise.one;

import java.util.Scanner;

public class Calculations {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final double PI = 3.14159;
		
		System.out.println("Enter with three numbers: ");
		double firstNumber = sc.nextDouble();
		double secondNumber = sc.nextDouble();
		double thirdNumber = sc.nextDouble();
		
		System.out.printf("Triangle: %.4f \n", ((firstNumber * thirdNumber) / 2));
		System.out.printf("Circle: %.4f \n", (PI * (thirdNumber * thirdNumber)));
		System.out.printf("Trapezoid: %.4f \n", (((firstNumber + secondNumber) * thirdNumber) / 2 ));
		System.out.printf("Square: %.4f \n", (secondNumber * secondNumber));
		System.out.printf("Retangle: %.4f", (firstNumber * secondNumber));
		
		sc.close();
	}
}

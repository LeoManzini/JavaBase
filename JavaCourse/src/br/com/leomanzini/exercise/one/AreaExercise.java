package br.com.leomanzini.exercise.one;

import java.util.Locale;
import java.util.Scanner;

public class AreaExercise {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		final double PI = 3.14159;
		
		System.out.println("Enter with a number to calculate the area: ");
		double radius = sc.nextDouble();
		double area = PI * (Math.pow(radius, 2.0));
		
		System.out.printf("The area calculated: %.4f", area);
		
		sc.close();
	}

}

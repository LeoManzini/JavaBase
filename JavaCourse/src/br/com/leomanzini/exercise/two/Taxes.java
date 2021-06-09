package br.com.leomanzini.exercise.two;

import java.util.Scanner;

public class Taxes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter with your salary: ");
		double salary = sc.nextDouble();
		
		double taxes;
		
		if(salary <= 2000.0) {
			taxes = 0.00;
		} else if (salary <= 3000.0) {
			taxes = (salary - 2000.0) * 0.08;
		} else if (salary <= 4500.0) {
			taxes = (salary - 3000.0) * 0.18 + 1000.0 * 0.08;
		} else {
			taxes = (salary - 4500.0) * 0.28 + 1500.0 * 0.18 + 1000.0 * 0.08;
		}
		
		if(taxes == 0.00) {
			System.out.println("Tax exempt");
		} else {
			System.out.printf("Tax R$ %.2f", taxes);
		}
		
		sc.close();
	}
}

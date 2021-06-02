package br.com.leomanzini.exercise.one;

import java.util.Scanner;

public class CalculateSalary {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter with the employee number: ");
		int employeeNumber = sc.nextInt();
		
		System.out.println("Enter with the hours worked: ");
		int workedHours = sc.nextInt();
		
		System.out.println("Enter how much you earns per hour: ");
		double hourSalary = sc.nextDouble();
		
		System.out.println("Employee number: " + employeeNumber);
		System.out.printf("Salary: U$ %.2f", hourSalary * workedHours);
		
		sc.close();
	}
}

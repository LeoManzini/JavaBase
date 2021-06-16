package br.com.leomanzini.lists.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ListExercise {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int employeeNumbers = sc.nextInt();
		
		List<Employees> employeeList = new ArrayList<>();
		
		for(int i = 0; i < employeeNumbers; i++) {
			System.out.println("\nEmployee #" + (i + 1));
			System.out.print("Id: ");
			int id = sc.nextInt();
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			Employees employee = new Employees(id, name, salary);
			
			employeeList.add(employee);
		}
		
		System.out.print("\nEnter with the employee id that will have salary increase: ");
		int id = sc.nextInt();
		
		Employees employee = employeeList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if (employee == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			employee.increaseSalary(percentage);
		}
		
		System.out.println("\nList of employees: ");
		
		for(Employees emp : employeeList) {
			System.out.println(emp);
		}
		
		sc.close();
	}
}

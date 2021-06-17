package br.com.leomanzini.enums;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ExerciseOne {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateMask = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter departament's name: ");
		String department = sc.nextLine();
		
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Level: ");
		String level = sc.nextLine();
		
		System.out.print("Base salary: ");
		double salary = sc.nextDouble();
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), salary, new Department(department));
		
		System.out.print("How many contracts to this worker? ");
		int contracts = sc.nextInt();
		
		for(int i = 0; i < contracts; i++) {			
			System.out.printf("Enter contract #%d data: \n", (i + 1));
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = dateMask.parse(sc.next());

			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(date, valuePerHour, hours);
			
			worker.addContract(contract);
		}
		
		System.out.print("\nEnter month and year to calculate income (MM/YYYY)");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}
}

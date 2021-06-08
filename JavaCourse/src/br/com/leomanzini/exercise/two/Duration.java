package br.com.leomanzini.exercise.two;

import java.util.Scanner;

public class Duration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter with the start and final hours: ");
		int startHour = sc.nextInt();
		int finalHour = sc.nextInt();
		
		int duration;
		
		if (startHour < finalHour) {
			duration = finalHour - startHour;
		} else {
			duration = 24 - startHour + finalHour;
		}
		
		System.out.printf("The game lasted: %d hours.", duration);
		
		sc.close();
	}
}

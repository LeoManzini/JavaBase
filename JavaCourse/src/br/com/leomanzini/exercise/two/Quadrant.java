package br.com.leomanzini.exercise.two;

import java.util.Scanner;

public class Quadrant {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter with the X and Y coordinates: ");
		double coordinateX = sc.nextDouble();
		double coordinateY = sc.nextDouble();
		
		if(coordinateX > 0 && coordinateY > 0) {
			System.out.println("Quadrant one.");
		} else if(coordinateX < 0 && coordinateY > 0) {
			System.out.println("Quadrant two.");
		} else if(coordinateX < 0 && coordinateY < 0) {
			System.out.println("Quadrant three.");
		} else if(coordinateX > 0 && coordinateY < 0) {
			System.out.println("Quadrant four.");
		} else {
			System.out.println("Origin.");
		}
		
		sc.close();
	}
}

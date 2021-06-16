package br.com.leomanzini.matrix;

import java.util.Scanner;

public class MatrixExercise {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter with the size of the lines and columns: ");
		int lines = sc.nextInt();
		int columns = sc.nextInt();
		
		int[][] matrix = new int[lines][columns];
		
		System.out.println("\nEnter with your matrix: ");
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("\nEnter with the number to search: ");
		int searchFor = sc.nextInt();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == searchFor) {
					System.out.println("\nNumber position: " + i + ", " + j);
					
					if(j > 0) {
						System.out.println("Left: " + matrix[i][j - 1]);
					}
					
					if(i > 0) {
						System.out.println("Up: " + matrix[i - 1][j]);
					}
					
					if(j < matrix[i].length - 1) {
						System.out.println("Right: " + matrix[i][j + 1]);
					}
					
					if(i < matrix.length - 1) {
						System.out.println("Down: " + matrix[i + 1][j]);
					}
				}
			}
		}
		
		sc.close();
	}
}

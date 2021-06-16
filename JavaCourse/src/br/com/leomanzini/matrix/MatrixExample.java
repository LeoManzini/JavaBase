package br.com.leomanzini.matrix;

import java.util.Scanner;

public class MatrixExample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];
		
		int negativeNumbersCounter = 0;
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) { //matrix[i].length second length
				matrix[i][j] = sc.nextInt();
				
				if(matrix[i][j] < 0) {
					negativeNumbersCounter++;
				}
			}
		}
		
		System.out.println("\nMain diagonal: ");
		
		for(int i = 0; i < matrix.length; i++) {
			System.out.print(matrix[i][i] + " ");
		}
		
		System.out.println("\n\nNegative numbers: " + negativeNumbersCounter);
		
		sc.close();
	}
}

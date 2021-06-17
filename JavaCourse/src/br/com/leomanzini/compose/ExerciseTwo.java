package br.com.leomanzini.compose;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExerciseTwo {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat dateMask = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comment commentOne = new Comment("Have a nice trip");
		Comment commentTwo = new Comment("Wow that's awesome!");
		
		Date moment = dateMask.parse("21/06/2018 13:05:44");
		String title = "Traveling to New Zealand";
		String content = "I'm goint to visit this wonderful country!";
		int likes = 12;
		
		Post postOne = new Post(moment, title, content, likes);
		postOne.addComments(commentOne);
		postOne.addComments(commentTwo);
		
		System.out.println(postOne);
		
		sc.close();
	}
}

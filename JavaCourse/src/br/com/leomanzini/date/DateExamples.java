package br.com.leomanzini.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class DateExamples {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat dateMask01 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateMask02 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		SimpleDateFormat gmtMask = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		gmtMask.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Date dateFirstMask = dateMask01.parse("23/12/1998");
		Date dateSecondMask = dateMask02.parse("23/12/1998 17:17:30");
		
		Date dateIsoMask = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		
		Date today = new Date();
		Date todayTimeMillis = new Date(System.currentTimeMillis());
		Date todayZero = new Date(0);
		Date milliToHours = new Date(1000L * 60L * 60L * 5L); // Multiply milliseconds to obtain hours
		
		System.out.println("--------------------------Using Br timezone--------------------------\n");
		
		System.out.println("First date: " + dateFirstMask);
		System.out.println("Second date: " + dateSecondMask);
		
		System.out.println("---------------------------------------------------------------------\n");
		
		System.out.println("First formated date: " + dateMask01.format(dateFirstMask));
		System.out.println("Second formated date: " + dateMask02.format(dateSecondMask));
		
		System.out.println("---------------------------------------------------------------------\n");
		
		System.out.println("Today date: " + dateMask02.format(today));
		System.out.println("Today date time millis: " + dateMask02.format(todayTimeMillis));
		
		System.out.println("---------------------------------------------------------------------\n");
		
		System.out.println("First date Java registered: " + dateMask02.format(todayZero));
		System.out.println("First date Java registered multiplying milli to hours: " + dateMask02.format(milliToHours));
		
		System.out.println("---------------------------------------------------------------------\n");
		
		System.out.println("ISO 8601 date format: " + dateMask02.format(dateIsoMask));
		
		System.out.println("\n--------------------------Using GMT timezone-------------------------\n");

		System.out.println("First formated date: " + gmtMask.format(dateFirstMask));
		System.out.println("Second formated date: " + gmtMask.format(dateSecondMask));
		
		System.out.println("---------------------------------------------------------------------\n");
		
		System.out.println("Today date: " + gmtMask.format(today));
		System.out.println("Today date time millis: " + gmtMask.format(todayTimeMillis));
		
		System.out.println("---------------------------------------------------------------------\n");
		
		System.out.println("First date Java registered: " + gmtMask.format(todayZero));
		System.out.println("First date Java registered multiplying milli to hours: " + gmtMask.format(milliToHours));
		
		System.out.println("---------------------------------------------------------------------\n");
		
		System.out.println("ISO 8601 date format: " + gmtMask.format(dateIsoMask));
	}
}

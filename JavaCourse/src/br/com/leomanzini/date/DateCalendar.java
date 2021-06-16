package br.com.leomanzini.date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class DateCalendar {

	public static void main(String[] args) {
		
		SimpleDateFormat dateMask = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date dateIso = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		
		System.out.println(dateMask.format(dateIso));
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateIso);
		calendar.add(Calendar.HOUR_OF_DAY, 4);
		dateIso = calendar.getTime();
		
		System.out.println(dateMask.format(dateIso));
		
		int minutes = calendar.get(Calendar.MINUTE);
		int month = 1 + calendar.get(Calendar.MONTH);
		
		System.out.println("Minutes: " + minutes);
		System.out.println("Month: " + month);
	}
}

package edu.neu.csye6200.utils;

import edu.neu.csye6200.model.Student;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	
	public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
	public static final DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	

	public static int calculateMonthsBetweenTwoDates(Student s) {
		String dateBefore = s.getEntryDate();
		String dateAfter = s.getLastRegistrationDate();
		int months=(int) ChronoUnit.MONTHS.between(LocalDate.parse(dateAfter,df),LocalDate.parse(dateBefore,df));
		return months;
	}
	
	public static String parseDatetoString(Date d){
		String date=simpleDateFormat.format(d);
		return date;
	}

}

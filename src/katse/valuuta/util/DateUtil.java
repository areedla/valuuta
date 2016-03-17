package katse.valuuta.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	
	public static String formatDate(Date date, String format){
		
		Format formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
	
	
	public static Date parseDate(String dateString, String format) throws ParseException{
		
		DateFormat df = new SimpleDateFormat(format);
		return  df.parse(dateString);		
	}
	
	public static Date getEile(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

}

package utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Timing {
	
	public Timing() {
		
	}
	
	/*public static String CurrentDateTime() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
			                     .withLocale(Locale.UK)
			                     .withZone(ZoneId.systemDefault());
	
		Instant instant = Instant.now();
		return formatter.format(instant);
	}*/
	
	public Instant CurrentDateTime_UTC() {
		Instant instant = Instant.now();
		return instant;
	}
	
	public LocalDateTime LocalDateTimeAtStartofDay() {		
		return LocalDate.now()
		        .atStartOfDay();
	}
	
	public Instant PastDateTime_UTC(long numberofsecondsinpast_FromNow) {
		Instant instant = Instant.now();
		return instant.minusSeconds(numberofsecondsinpast_FromNow);
	}
	
	public Instant FutureDateTime_UTC(long numberofsecoundsinFuture_FromNow) {
		Instant instant = Instant.now();
		return instant.plusSeconds(numberofsecoundsinFuture_FromNow);
	}
	
	public String FutureDate(int numberofdaysinFuturefromToday) {
		LocalDate today = LocalDate.now();
		LocalDate newDay = today.plusDays(numberofdaysinFuturefromToday);
		return newDay.toString();
	}
	
	public String CurrentDate() {
		LocalDate today = LocalDate.now();
		return today.toString();
	}
	
	public String PastDate(int numberofdaysinPastfromToday) {
		LocalDate today = LocalDate.now();
		LocalDate newDay = today.minusDays(numberofdaysinPastfromToday);
		return newDay.toString();	
	}
	
	public String getCurrentHour()
	{
		SimpleDateFormat formatHours = new SimpleDateFormat("HH");
				String getHours = formatHours.format(new Date());
				
				return getHours;
	}
	
	public String getnexthourfromnow()
	{
		SimpleDateFormat formatHours = new SimpleDateFormat("HH");
	      Calendar calendar = Calendar.getInstance();
	      //System.out.println("Current Date = " + calendar.getTime());
	      // Incrementing hours by 5
	      calendar.add(Calendar.HOUR_OF_DAY, +1);
	      //System.out.println("Updated Date = " + calendar.getTime());
	      return formatHours.format(calendar.getTime());
	}
	public String getCurrentMinute()
	{
		SimpleDateFormat formatMinutes = new SimpleDateFormat("mm");
				String getMinutes = formatMinutes.format(new Date(System.currentTimeMillis()+1*60*1000));
				
				return getMinutes;
	}
	public void WaitingElementtovisible(long milis)
	{
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public String getCurrentDateTimeUTC() {
		
		SimpleDateFormat gmtDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		gmtDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

		//Current Date Time in UTC
		//System.out.println("Current Date and Time in UTC time zone: " + gmtDateFormat.format(new Date()));
		return gmtDateFormat.format(new Date());
		
	}
	
	

}

package WebRepo;

import java.awt.Robot;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import utils.TestData;

public class WebRepos {
	
	public WebRepos() {
		
	}
	
	public static String extractNumber(final String str) {                

	    if(str == null || str.isEmpty()) return "";

	    StringBuilder sb = new StringBuilder();
	    boolean found = false;
	    for(char c : str.toCharArray()){
	        if(Character.isDigit(c)){
	            sb.append(c);
	            found = true;
	        } else if(found){
	            // If we already found a digit before and this char is not a digit, stop looping
	            break;                
	        }
	    }

	    return sb.toString();
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
	
	public String _getCurrentMinuteplusone()
	{
		SimpleDateFormat formatMinutes = new SimpleDateFormat("mm");
				String getMinutes = formatMinutes.format(new Date(System.currentTimeMillis()+60*1000));
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
	
	public static String requestedTimeinPast(int pasthours) {
		
		Object hourpastcurrenttime = Instant.now().minus(pasthours, ChronoUnit.HOURS);
		String a = hourpastcurrenttime.toString().replace('T', ' ').replace('Z', ' ');
		System.out.println(a.substring(0, a.length()-5));
		return a.substring(0, a.length()-5);
}
	
	public void PickupDateTimeSetto48HourinPast(int tripid) throws SQLException, IOException, InterruptedException {
		TestData testdata = new TestData();
		Connection conn = DriverManager.getConnection(testdata.properties.getProperty("DB"),
				testdata.properties.getProperty("dbusername"), testdata.properties.getProperty("dbpassword"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Statement st = conn.createStatement();

			st.executeUpdate("update `trip_details` set `pickup_date_time_utc` = '"
					+ requestedTimeinPast(48) + "' where `id` = " + tripid + ";");

		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			conn.close();
			//System.out.println("Check if the DB query is executed and connection is closed: " + conn.isClosed());
		}

		Thread.sleep(20000);

	}
	
	public void PrintMe(String header, String variable)
	{
		//System.out.println(header+variable);
	}
	

}

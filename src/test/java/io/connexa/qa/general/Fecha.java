package io.connexa.qa.general;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fecha {

	static Calendar rightNow = Calendar.getInstance();
	
	static SimpleDateFormat date = new SimpleDateFormat ("yyyy-MM-dd");
	static SimpleDateFormat hour = new SimpleDateFormat ("HH:mm");
		
	private static String startDate ; 
	private static String startHour ;
	private static String endDate ;
	private static String endHour;
	
	public Fecha (){
					
	}
	
	public static String getStartDate(){
		startDate = date.format(rightNow.getTime()); 
		return startDate;
		
	}
	
	public static String getStartHour(){
		startHour = hour.format(rightNow.getTime());
		return startHour;
		
	}
	
	public static String getEndDate(){
		endDate = date.format(rightNow.getTime());
		return endDate;
		
	}
	
	public static String getEndHour(){
		rightNow.add(Calendar.MINUTE,5);
		endHour = hour.format(rightNow.getTime());;

		return endHour;
		
	}
	
		
}

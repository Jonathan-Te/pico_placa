package utils;

import java.util.Date;

public class DateUtils {
	
	@SuppressWarnings("deprecation")
	public static boolean compareTwoDates(Date date1, Date date2) {
		
		if (date1==null || date2==null)
			return false;
			
		return date1.getYear()==date2.getYear() && date1.getMonth()==date2.getMonth() && date1.getDate()==date2.getDate();
	}
	
	public static boolean isBetween(Date date, Double start, Double end) {
		
		if (start==null || end==null )
			return false;
		
		Date startD = new Date(date.getYear(),date.getMonth(),date.getDate(),start.intValue(),(int)((start-start.intValue())*60),0);
		Date endD = new Date(date.getYear(),date.getMonth(),date.getDate(),end.intValue(),(int)((end-end.intValue())*60),0);
		return date.after(startD) && date.before(endD);
	}

	public static boolean compareTwoDays(Date queriedDate, String applicationDays) {
		// TODO Auto-generated method stub
		if (applicationDays==null)
			return false;
		return applicationDays.contains(Integer.toString(queriedDate.getDay()));
	}



}

package herokuapp.backbase.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFunctions {
	
	/**
	 * Change date format
	 * 
	 * @return date in String
	 */
	public String dateConvert(String D){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("dd MMM yyyy");
        Date date = null;
        try {
            date = format1.parse(D);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateString = format2.format(date);
        System.out.println(dateString);
        return (dateString);
    }
}

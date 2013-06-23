package pas.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Collection of different standardisations
 * 
 * @author BKorthals
 */
public final class Format {
    
    private static final String shortDateFormat = "dd-MM-yyyy";
    private static final String shorteTimeFormat = "HH:mm";
    
   /*
    * Conferts Date object to small date dd-MM-yyyy
    * 
    * @param Date
    * @return String formatted date
    */
    public  static String toShortDateString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat(Format.shortDateFormat);
        return formatter.format(date);
    }
    
    
   /*
    * Conferts Date object to small date dd-MM-yyyy
    * 
    * @param Date
    * @return String formatted date
    */
    public static String toShortTimeString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(Format.shorteTimeFormat);
        return formatter.format(date);
    }
    
}

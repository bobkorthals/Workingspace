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
    
}

package ticketinco.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by acabrera on 10/31/16.
 */
public class DateUtil {

    public static Date addSeconds(Date date, int seconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, seconds);

        return cal.getTime();
    }
}

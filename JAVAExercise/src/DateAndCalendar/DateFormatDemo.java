package DateAndCalendar;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import static java.util.Locale.CHINA;

/**
 * Created by zhuxinquan on 16-5-31.
 */
public class DateFormatDemo {
    public static void main(String[] args) {
//        DateFormat df = DateFormat.getDateInstance();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
//        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, Locale.CHINA);
        String nowDate = df.format(new Date());
        System.out.println("current Date:" + nowDate);
    }
}
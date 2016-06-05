package DateAndCalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by zhuxinquan on 16-5-31.
 * 日历类
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
//        Calendar c1 = new GregorianCalendar();
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.HOUR));
        System.out.println(c.get(Calendar.MINUTE));
        System.out.println(c.get(Calendar.MILLISECOND));

    }
}

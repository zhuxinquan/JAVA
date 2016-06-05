package DateAndCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhuxinquan on 16-5-31.
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS");
        String s = sdf.format(new Date());
        System.out.println(s);
    }
}

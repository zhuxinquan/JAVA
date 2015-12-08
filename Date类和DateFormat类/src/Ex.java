import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * Created by zhuxinquan on 15-11-30.
 */
public class Ex {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yy/MM/dd  hh:mm:ss");
        System.out.println(f.format(date));
    }
}

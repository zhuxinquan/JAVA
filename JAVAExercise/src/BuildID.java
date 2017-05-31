import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by zhuxinquan on 5/31/17.
 */
public class BuildID {

    public static String makeID(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mm = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);
        UUID uuid = UUID.randomUUID();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
        String time = simpleDateFormat.format(calendar.getTime());
        return String.valueOf(year) + "-" + uuid.toString().substring(0, 8) + "-" + time;
    }

    public static void main(String[] args) {
        System.out.println(makeID());
    }
}

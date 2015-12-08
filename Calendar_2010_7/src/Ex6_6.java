import java.util.Calendar;

/**
 * Created by zhuxinquan on 15-11-30.
 */
public class Ex6_6 {
    public static void main(String[] args) {
        System.out.println("日 一  二 三  四 五  六");
        Calendar myCal = Calendar.getInstance();
        myCal.set(Calendar.YEAR, 2010);
        myCal.set(Calendar.MONTH, 6);
        myCal.set(Calendar.DAY_OF_MONTH, 1);
        int weekNo = myCal.get(Calendar.DAY_OF_WEEK) - 1;
        //System.out.println(weekNo);
        String[] myWeek = new String[weekNo + 31];
        for (int i = 0; i < weekNo; i++) {
            myWeek[i] = "  ";
        }
        for (int i = weekNo, n = 1; i < weekNo + 31; i++) {
            //保证一位数与两位数的输出宽度相同
            if (n <= 9) {
                myWeek[i] = " " + String.valueOf(n);
            } else {
                myWeek[i] = String.valueOf(n);
            }
            n++;
        }
        for (int i = 0; i < myWeek.length; i++) {
            if (i % 7 == 0) {
                System.out.println();
            }
            System.out.print(myWeek[i] + " ");
        }
    }
}

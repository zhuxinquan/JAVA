/**
 * Created by zhuxinquan on 15-12-1.
 */
enum Week{
    sun, mon, tue, wed, thu, fri, sat
}
public class Ex6_9 {
    public static void main(String[] args) {
        Week[] weeks = Week.values();
        for(Week No: weeks){
            System.out.print(No.ordinal() + "-" + No.name() + " ");
        }
    }
}

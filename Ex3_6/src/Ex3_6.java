import java.util.Scanner;

/**
 * Created by zhuxinquan on 15-11-17.
 */
public class Ex3_6 {
    public static void main(String[] args){
        (new Grade()).toGrade();
    }
}

class Grade{
    public void toGrade(){
        int score, m;
        Scanner reader = new Scanner(System.in);
        System.out.println("输入成绩：");
        score = reader.nextInt();
        if(score < 0 || score > 100){
            System.out.println("data error");
        }
        else{
            m = score/10;
            switch(m)
            {
                case 9:
                case 10:System.out.println("the grade is A");   break;
                case 8: System.out.println("the grade is B");   break;
                case 7: System.out.println("the grade is C");   break;
                case 6: System.out.println("the grade is D");   break;
                default : System.out.println("the grade is E");   break;
            }
        }
    }
}

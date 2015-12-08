package Chapter7;

import javax.swing.*;

/**
 * Created by zhuxinquan on 15-12-3.
 */
public class Ex7_8 {
    public static void main(String[] args) {
        String first = JOptionPane.showInputDialog(null, "请输入第一个字符串：", "SubstrJudge", JOptionPane.QUESTION_MESSAGE);
        String second = JOptionPane.showInputDialog(null, "请输入第二个字符串：", "SubstrJudge", JOptionPane.PLAIN_MESSAGE);
        if(isSubstring(first, second)){
            System.out.println(first + " is a substring of " + second);
        }else {
            System.out.println(first + " is not a substring of " + second);
        }
    }

    public static boolean isSubstring(String first, String second){
        int remainingLength = second.length();
        int startingIndex = 0;
        toWhile: while(first.length() <= remainingLength){
            for(int i = 0; i < first.length(); i++){
                if(first.charAt(i) != second.charAt(startingIndex + i)){
                    startingIndex++;
                    remainingLength--;
                    continue toWhile;
                }
            }
            return true;
        }
        return false;
    }
}

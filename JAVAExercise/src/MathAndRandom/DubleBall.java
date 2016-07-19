package MathAndRandom;

import java.util.Random;
import java.util.Scanner;

/**
 * 双色球彩票模拟
 * Created by zhuxinquan on 16-7-18.
 */
public class DubleBall {
    public static void main(String[] args) {
        int  sysBlueBallNum;
        int[] sysRedBallNum = new int[6];
        int userBlueBallNum;
        int[] userRedBallNum = new int[6];

        int blueBall = 0;
        int redBallCount = 0;

        Random r = new Random();
        Scanner input = new Scanner(System.in);

        int[] redNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};

        sysBlueBallNum = r.nextInt(16) + 1;
        for(int i = 0; i < sysRedBallNum.length; i++){
            while(true){
                int index = r.nextInt(33);
                if(redNum[index] != 0){
                    sysRedBallNum[i] = redNum[index];
                    redNum[index] = 0;
                    break;
                }
            }
        }

        System.out.print("input BlueBall (16 选 1): ");
        userBlueBallNum = input.nextInt();
        System.out.println("input RedBall (33 选 6): ");
        for(int i = 0; i < userRedBallNum.length; i++){
            userRedBallNum[i] = input.nextInt();
        }

        if(userBlueBallNum == sysBlueBallNum){
            blueBall = 1;
        }

        for(int i = 0; i < userRedBallNum.length; i++){
            for(int j = 0; j < sysRedBallNum.length; j++){
                if(userRedBallNum[i] == sysRedBallNum[j]){
                    redBallCount++;
                    break;
                }
            }
        }

        int temp;
        for(int i = 0; i < sysRedBallNum.length - 1; i++){
            for(int j = 0; j < sysRedBallNum.length - 1 - i; j++){
                if(sysRedBallNum[j] > sysRedBallNum[j + 1]){
                    temp = sysRedBallNum[j + 1];
                    sysRedBallNum[j + 1] = sysRedBallNum[j];
                    sysRedBallNum[j] = temp;
                }
            }
        }

        System.out.print("Red: ");
        for(int i = 0; i < sysRedBallNum.length; i++){
            System.out.print(sysRedBallNum[i] + " ");
        }
        System.out.println();
        System.out.print("Blue: " + sysBlueBallNum);
    }
}

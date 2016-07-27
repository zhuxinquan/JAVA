package com.get_blog_content;

/**
 * Created by zhuxinquan on 16-4-26.
 * 传入一个
 */
public class Time {
    public static String getStandardTime(String time) {
        String ans = "";
        if(time.charAt(0) == '2')
        {
            ans += time.substring(0, 4);
            ans += '-';
            int pos = 5;
            while(time.charAt(pos) <= '9'
                    && time.charAt(pos) >= '0') {
                ans += time.charAt(pos);
                pos++;
            }
            pos++;
            ans += '-';
            while(time.charAt(pos) <= '9'
                    && time.charAt(pos) >= '0') {
                ans += time.charAt(pos);
                pos++;
            }
            pos++;
            ans += ' ';
            ans += time.substring(pos, pos+8);
        }
        else {
            String[] m = new String[]{
                    "Jan",
                    "Feb",
                    "Mar",
                    "Apr",
                    "May",
                    "Jun",
                    "Jul",
                    "Aug",
                    "Sep",
                    "Oct",
                    "Nov",
                    "Dec"
            };

            ans += time.substring(12, 16);
            ans += '-';
            String temp = time.substring(8, 11);
            for(int i=0; i<12; i++)
                if(m[i].compareTo(temp) == 0)
                {
                    ans += i+1;
                    break;
                }
            ans += '-';
            if(time.charAt(5) != '0')
                ans += time.charAt(5);
            ans += time.charAt(6);
            ans += ' ';
            ans += time.substring(17, 17+8);
        }
        return ans;
    }
}

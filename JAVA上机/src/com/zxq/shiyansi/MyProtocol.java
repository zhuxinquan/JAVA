package com.zxq.shiyansi;

/**
 * Created by zhuxinquan on 16-11-7.
 */
public class MyProtocol {

    private int state = 0;

    public String processInput(String theInput){
        String theOutput = null;
        if(state == 0){
            theOutput = "Hello";
            state = 1;
        }else if( state == 1){
            if(theInput.equalsIgnoreCase("hello")){
                theOutput = "Nice to meet you";
                state = 2;
            }else
                theOutput = "You are supposed to say \" hello \"! Try again.";
        }else if( state == 2){
            if(theInput.equalsIgnoreCase("Nice to meet you too!")){
                theOutput = "bye";
                state = 3;
            }else{
                theOutput = "You are supposed to say \"Nice to meet you too!\" Try again.";
            }
        }
        return theOutput;
    }
}

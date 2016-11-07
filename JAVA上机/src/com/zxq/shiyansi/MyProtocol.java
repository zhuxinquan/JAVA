package com.zxq.shiyansi;

/**
 * Created by zhuxinquan on 16-11-7.
 */
public class MyProtocol {
    private static final int WAITING = 0;
    private static final int SENDKNOCK = 1;
    private static final int SENDCLUE = 2;
    private static final int ANOTHER = 3;
    private static final int NUMJOKES = 5;
    private int state = WAITING;
    private int currentJoke = 0;

    private String [] clues = {"Turnip", "Little Old Lady", "Atch",
            "Lamp", "Godness"};
    private String [] answers = {"Turnip the heat, it's cold in here!",
            "I did not know you could come!",
            "Bless you",	"Lamp is bright",
            "Godness is happy"
    };

    public String processInput(String theInput){
        String theOutput = null;
        if(state == WAITING){
            theOutput = "Knock! Knock!...";
            state = SENDKNOCK;
        }else if( state == SENDKNOCK){
            if(theInput.equalsIgnoreCase("Who's there?")){
                theOutput = clues[currentJoke];
                state = SENDCLUE;
            }else
                theOutput = "You are supposed to say \" Who's there? \"! Try again.";
        }else if( state == SENDCLUE){
            if(theInput.equalsIgnoreCase(clues[currentJoke] + "Who?")){
                theOutput = answers[currentJoke] + "Want another?(y/n)";
                state = ANOTHER;
            }else{
                theOutput = "You are supposed to say \"" + clues[currentJoke] + "Who? \"! Try again. Knock! Knock!!!";
                state = SENDKNOCK;
            }
        }else if( state == ANOTHER){
            if(theInput.equalsIgnoreCase("y")){
                theOutput = "Knock! Knock!!!";
                if(currentJoke == (NUMJOKES - 1))
                    currentJoke = 0;
                else
                    currentJoke ++;
                state = SENDKNOCK;
            }else{
                theOutput = "bye";
                state = WAITING;
            }
        }
        return theOutput;
    }
}

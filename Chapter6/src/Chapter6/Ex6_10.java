package Chapter6;

/**
 * Created by zhuxinquan on 15-12-1.
 */

enum Color{
    RED, BLUE, GREEN;
    private String s;
    public String toString(){
        switch(this) {
            case RED:
                s = "it's red!";
                break;
            case BLUE:
                s = "it's blue!";
                break;
            case GREEN:
                s = "it's green!";
                break;
            default:
                s = "unknow color !";
                break;
        }
        return s;
    }
}

public class Ex6_10 {
    public static void main(String[] args) {
        Color[] colors = Color.values();
        for(Color c: colors){
            System.out.println(c.ordinal()+"-"+c.name()+"-"+c+"");
        }
        System.out.println();
    }
}

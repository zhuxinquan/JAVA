/**
 * Created by zhuxinquan on 15-12-3.
 */

class ObjectFoo<T>{
    private T x;
    public ObjectFoo(T x){
        this.x = x;
    }
    public T getX(){
        return x;
    }
    public void setX(T x){
        this.x = x;
    }
}

public class Ex_question_6 {
    public static void main(String[] args) {
        ObjectFoo strFoo = new ObjectFoo<String>("Hello Generics!");
        ObjectFoo douFoo = new ObjectFoo<Double>(new Double("33"));
        ObjectFoo objFoo = new ObjectFoo<Object>(new Object());
        System.out.println("strFoo.getX = " + strFoo.getX());
        System.out.println("douFoo.getX = " + douFoo.getX());
        System.out.println("object.getX = " + objFoo.getX());
    }
}

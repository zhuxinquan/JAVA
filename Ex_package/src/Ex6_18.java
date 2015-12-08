/**
 * Created by zhuxinquan on 15-12-3.
 */

class Box<T extends Number>{
    private T object;
    public void setObject(T object){
        this.object = object;
    }
    public void setObject(Box<? extends T>obj){
        T o = obj.getObject();
        object = o;
    }
    public T getObject(){
        return object;
    }
    public void showType(){
        System.out.println("实际类型是："+object.getClass().getName());
    }
}

public class Ex6_18 {
    public static void main(String[] args) {
        Box<Number>numObj;
        numObj = new Box<Number>();
        Box<Integer>intObj = new Box<Integer>();
        intObj.setObject(new Integer(123));
        numObj.setObject(intObj);
        numObj.showType();
        System.out.println("value = " + numObj.getObject());

        Box<Double>douObj = new Box<Double>();
        douObj.setObject(new Double(2.1728));
        numObj.setObject(douObj);
        numObj.showType();
        System.out.println("value = " + numObj.getObject());
        //Double doubleO = numObj.getObject();
        //Number类不能转换为它的子类
    }
}

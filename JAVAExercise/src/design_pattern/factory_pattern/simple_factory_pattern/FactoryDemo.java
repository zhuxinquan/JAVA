package design_pattern.factory_pattern.simple_factory_pattern;

/**
 * Created by zhuxinquan on 16-7-20.
 * 工厂设计模式：由一个工厂对象决定创建出哪一种产品的实例
 */
public class FactoryDemo {
    public static void main(String[] args) {
//        ClothDoll cd = new ClothDoll();
//        System.out.println(cd.getInfo());
//        BarbieDoll bd = new BarbieDoll();
//        System.out.println(bd.getInfo());
        Doll d = DollFactory.getInstance("cloth");
        if(d != null)
            System.out.println(d.getInfo());
    }
}

interface Doll{
    public String getInfo();
}

class DollFactory{
    public static Doll getInstance(String name){
        if("cloth".equals(name)){
            return new ClothDoll();
        }else if("barbie".equals(name)){
            return new BarbieDoll();
        }
        return null;
    }
}

class ClothDoll implements Doll{
    public String getInfo(){
        return "布娃娃";
    }
}

class BarbieDoll implements Doll{
    public String getInfo(){
        return "芭比娃娃";
    }
}

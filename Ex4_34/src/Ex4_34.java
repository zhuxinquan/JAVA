/**
 * Created by zhuxinquan on 15-11-23.
 */
public class Ex4_34 {
    public static void listNameInParty(String str, Object ...names){
        System.out.print("str = "+str+" ");
        for(Object name: names){
            System.out.print(name + "");
        }
        System.out.println();
    }

    public static void main(String[] args){
        String[] name = new String[]{"张三", "李四", "王五"};
        listNameInParty("丁一");
        listNameInParty("倪二", (Object)new String[]{"张三", "李四", "王五"});
        listNameInParty("5", 1, 3.14f, 2.71828, 'a', "陈六", "true");
    }
}

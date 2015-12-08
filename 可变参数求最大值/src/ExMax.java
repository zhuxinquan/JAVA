/**
 * Created by zhuxinquan on 15-11-23.
 */
public class ExMax {
    public static void test(int ...objects){
        if(objects.length > 0) {
            int max = objects[0];

            for (int i : objects) {
                if (max < i) {
                    max = i;
                }
            }
            System.out.println(max);
        }
    }

    public static void main(String[] args){
        test();
        test(2, 4, 6, 1);
    }
}

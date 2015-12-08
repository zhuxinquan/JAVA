import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

/**
 * Created by zhuxinquan on 15-11-30.
 */
public class Ex6_4 {
    public static void main(String[] args) {
        Integer iObj1 = 100;
        Integer iObj2 = 100;
        Integer iObj3 = new Integer(100);
        Integer iObj4 = new Integer(100);
        if(iObj1 == iObj2){
            System.out.println("iObj1 iObj2相等");
        }else{
            System.out.println("iObj1 iObj2不相等");
        }
        if(iObj3 == iObj4){
            System.out.println("iObj3 iObj4相等");
        }else{
            System.out.println("iObj3 iObj4不相等");
        }
    }
}

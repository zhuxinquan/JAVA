/**
 * Created by zhuxinquan on 15-11-20.
 */
package chapter4;
class StaticImportee{
    public static int one = 1;
    public static final int TWO = 2;
    public static int three(){
        return 3;
    }

    public static class Four{
        public int value(){
            return 4;
        }
    }
}
package Chapter6;

/**
 * Created by zhuxinquan on 15-12-1.
 */

interface IDescription{
    public String getDescription();
}

enum ClothesSize implements IDescription{
    LARGE{
        public String getDescription(){
            return "大号";
        }
    },
    MEDIUM{
        public String getDescription() {
            return "中号";
        }
    },
    SMALL{
        public String getDescription() {
            return "小号";
        }
    };
}

public class Ex6_12 {
    public static void main(String[] args) {
        for(ClothesSize clothe: ClothesSize.values()){
            System.out.println(clothe + ":" + clothe.getDescription());;
        }
    }
}

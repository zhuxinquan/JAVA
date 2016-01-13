import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by zhuxinquan on 16-1-13.
 * 输出目录中匹配的文件
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File("/home/zhuxinquan/IdeaProjects/JavaIOExercise/src");
        String[] list;
        if(args.length == 0){
            list = path.list();
        }else{
            //DirFilter类实现了FilenameFilter中的方法，用来进行过滤
            list = path.list(new DirFilter(args[0]));
        }
        //String.CASE_INSENSITIVE_ORDER为不区分大小写对字符串进行排序
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list){
            System.out.println(dirItem);
        }
    }
}

class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter(String regex){
        //将给定的正则表达式编译并赋予给Pattern类
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir, String name){
        //matcher生成一个给定命名的Matcher对象,matches对输入的字串以该正则表达式为模开展匹配
        return pattern.matcher(name).matches();
    }
}

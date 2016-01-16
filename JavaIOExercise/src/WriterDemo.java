import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by zhuxinquan on 16-1-16.
 */
public class WriterDemo {

    public static void writer1() throws IOException {
        File f = new File("./test.txt");
        Writer out = new FileWriter(f, true);
        String info = "good good study, day day up!";
        out.write(info);
        out.close();
    }

    public static void main(String[] args) throws IOException {
        writer1();
    }
}

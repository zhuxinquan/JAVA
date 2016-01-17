import java.io.*;

/**
 * Created by zhuxinquan on 16-1-17.
 */
public class PrintStreamDemo {

    /**
     * 使用printWriter打印流
     */
    public static void print1() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("./test.txt"));
        PrintWriter pw = new PrintWriter(bw, true);
        pw.println(105);
        pw.println("test PrintWriter");
        pw.print("\r\n");
        pw.flush();
        pw.close();
        bw.close();
    }

    /**
     * 使用printStream打印流
     */
    public static void print(){
        try {
            OutputStream out = new FileOutputStream("./test.txt");
            BufferedOutputStream bos = new BufferedOutputStream(out);
            PrintStream ps = new PrintStream(bos);
            ps.println(3.14f);
            ps.print(188);
            ps.println(true);
            ps.println("test PrintStream");
//            ps.flush();
            ps.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        print1();
    }
}

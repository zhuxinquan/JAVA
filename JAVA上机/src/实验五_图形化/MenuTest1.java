package 实验五_图形化;
import java.awt.*;
public class MenuTest1{
    public static void main(String args[]){
        Frame fr=new Frame("Menu");
        MenuBar mb=new MenuBar();
        fr.setMenuBar(mb);
        Menu m1=new Menu("File");
        Menu m2=new Menu("Format");
        Menu m3=new Menu("Help");
        Menu m4=new Menu("进制");
        mb.add(m1);
        mb.add(m2);
        mb.setHelpMenu(m3);
        MenuItem m21=new MenuItem("中文");
        MenuItem m41=new MenuItem("二进制");
        MenuItem m42=new MenuItem("八进制");
        MenuItem m43=new MenuItem("十进制");
        m2.add(m21);
        m2.add(m4);
        m4.add(m41);
        m4.add(m42);
        m4.add(m43);
        fr.pack();
        fr.setVisible(true);
    }
}
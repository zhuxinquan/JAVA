import javax.swing.*;
import java.awt.*;

/**
 * Created by zhuxinquan on 16-10-26.
 */
public class Main {
    public static void main(String[] args) {
        init();
    }

    public static void init(){
        JFrame jFrame = new JFrame("微波炉");
        Panel p = new Panel();
        p.setBounds(30, 30, 1, 1);
        JButton button = new JButton("开关");
        Dimension size = button.getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        button.setPreferredSize(size);
        button.setContentAreaFilled(false);
        button.setBackground(Color.green);
        p.add(button);
        jFrame.add(p);
        jFrame.setVisible(true);
    }
}

package 实验五_图形化;


import java.awt.*;
import java.awt.event.*;

/**
 * Created by zhuxinquan on 16-6-15.
 */
public class TestActionEvent {
    public static void main(String args[]) {
        Frame f = new Frame("Test");
        Button b = new Button("Press Me!");
        Monitor bh = new Monitor();
        b.addActionListener(bh);
        f.add(b,BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}

class Monitor implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("a button has been pressed");
    }
}


package 实验五_图形化;

import java.awt.*;

/**
 * Created by zhuxinquan on 16-6-15.
 */
public class GridLayoutWindow extends Frame {
    public GridLayoutWindow() {
        setLayout(new GridLayout(3,2));
        add(new Button("b1"));
        add(new Button("b2"));
        add(new Button("b3"));
        add(new Button("b4"));
        add(new Button("b5"));
        add(new Button("b6"));
    }
    public static void main(String args[]) {
        GridLayoutWindow window = new GridLayoutWindow();
        window.setTitle("GridWindow Application");
        window.pack();
        window.setVisible(true);
    }
}

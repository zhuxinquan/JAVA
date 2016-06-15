package 实验五_图形化;

import java.awt.*;

/**
 * Created by zhuxinquan on 16-6-15.
 */
public class BorderLayoutWindow extends Frame {
    public BorderLayoutWindow() {
        setLayout(new BorderLayout());
        add(new Button("BN"), "North");
        add( new Button("BS"),"South");
        add( new Button("BE"),"East");
        add( new Button("BW"),"West");
        add( new Button("BC"),"Center");
    }
    public static void main(String args[]) {
        BorderLayoutWindow window = new BorderLayoutWindow();
        window.setTitle("BorderWindow Application");
        window.pack();
        window.setVisible(true);
    }
}

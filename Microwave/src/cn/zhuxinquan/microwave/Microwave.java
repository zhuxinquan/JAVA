package cn.zhuxinquan.microwave;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zhuxinquan on 2016-11-02.
 */
public class Microwave extends JFrame{

    JButton startButton = new JButton("电源");
    Label startLabel = new Label("关");
    Label timeLabel = new Label("00:00:00");
    CheckboxGroup gears = new CheckboxGroup();
    Label dangweiLabel = new Label("档位：");
    Label timeLabel1 = new Label("时间：");
    Checkbox pengtiao = new Checkbox("烹调", gears, true);
    Checkbox hongkao = new Checkbox("烘烤", gears, false);
    Checkbox jiedong = new Checkbox("解冻", gears, false);

    CheckboxGroup times = new CheckboxGroup();
    Checkbox fancai = new Checkbox("饭菜3min", times, true);
    Checkbox niunai = new Checkbox("牛奶2min", times, false);
    Checkbox mantou = new Checkbox("馒头1min", times, false);
    Checkbox zidingyi = new Checkbox("自定义", times, false);
    JSpinner jSpinner1 = new JSpinner();
    JLabel minutes = new JLabel("min");
    JSpinner jSpinner2 = new JSpinner();
    JLabel seconds = new JLabel("s");
    JLabel warning = new JLabel("");
    Button start = new Button("开始");
    Button stop = new Button("停止");

    //定义当前电源状态
    private int powerFlag = 0;
    private int min = 0;
    private int sec = 0;
    //定义启动状态，0为关闭，1运行，2暂停
    private volatile int startFlag = 0;


    public Microwave() throws HeadlessException {
        init();
    }

    public void init(){
        this.setBackground(Color.lightGray);
        this.setLayout(null);
        this.setBounds(100, 100, 600, 400);
        this.setTitle("微波炉模拟仿真");

        //设置开关按钮及指示灯
        startButton.setBounds(60, 20, 70, 70);
        startButton.setFont(new Font("宋体", 1, 15));
        this.add(startButton);
        startLabel.setBounds(140, 45, 20, 20);
        startLabel.setBackground(Color.gray);
        startLabel.setFont(new Font("宋体", 0, 15));
        this.add(startLabel);
        startButton.addActionListener(new StartLister());

        //设置倒计时模块
        timeLabel.setFont(new Font("宋体", 0, 35));
        timeLabel.setBounds(360, 30, 140, 55);
        timeLabel.setBackground(Color.gray);
        this.add(timeLabel);

        //档位设置组合
        gears.setSelectedCheckbox(pengtiao);
        gears.setSelectedCheckbox(hongkao);
        gears.setSelectedCheckbox(jiedong);
        pengtiao.setFont(new Font("宋体", 0, 15));
        hongkao.setFont(new Font("宋体", 0, 15));
        jiedong.setFont(new Font("宋体", 0, 15));

        dangweiLabel.setBounds(60, 130, 100, 40);
        dangweiLabel.setFont(new Font("宋体", 0, 20));
        this.add(dangweiLabel);
        pengtiao.setBounds(200, 140, 70, 20);
        this.add(pengtiao);
        hongkao.setBounds(330, 140, 70, 20);
        this.add(hongkao);
        jiedong.setBounds(450, 140, 70, 20);
        this.add(jiedong);

        //时间组合设置
        timeLabel1.setFont(new Font("宋体", 0, 20));
        timeLabel1.setBounds(60, 180, 100, 40);
        fancai.setFont(new Font("宋体", 0, 15));
        fancai.setBounds(200, 190, 85, 20);
        niunai.setFont(new Font("宋体", 0, 15));
        niunai.setBounds(330, 190, 85, 20);
        mantou.setFont(new Font("宋体", 0, 15));
        mantou.setBounds(450, 190, 85, 20);
        zidingyi.setFont(new Font("宋体", 0, 15));
        zidingyi.setBounds(200, 230, 85, 20);

        //自定义分钟描述组合
        jSpinner1.setBounds(285, 230, 40, 20);
        jSpinner2.setBounds(375, 230, 40, 20);
        jSpinner1.addChangeListener(new MinLister());
        jSpinner2.addChangeListener(new SecLister());
        minutes.setFont(new Font("宋体", 0, 20));
        seconds.setFont(new Font("宋体", 0, 20));
        minutes.setBounds(330, 230, 40, 20);
        seconds.setBounds(420, 230, 40, 20);
        this.add(jSpinner1);
        this.add(jSpinner2);
        this.add(minutes);
        this.add(seconds);

        this.add(timeLabel1);
        this.add(fancai);
        this.add(niunai);
        this.add(mantou);
        this.add(zidingyi);

        warning.setBounds(465, 230, 40, 20);
        warning.setFont(new Font("宋体", 1, 15));
        this.add(warning);

        //设置开始及停止按钮
        start.setFont(new Font("宋体", 0, 22));
        start.setBounds(330, 300, 70, 35);
        stop.setFont(new Font("宋体", 0, 22));
        stop.setBounds(460, 300, 70, 35);
        start.addActionListener(new Start());
        stop.addActionListener(new Stop());
        this.add(start);
        this.add(stop);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }

    class Start implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(powerFlag == 0 || !warning.getText().equals("")){
                return ;
            }
            startFlag = 1;
            String dangwei = gears.getSelectedCheckbox().getLabel();
            String shijian = times.getSelectedCheckbox().getLabel();
            if(dangwei.equals("烹调")){

            }else if(dangwei.equals("烘烤")){

            }else {

            }

            if(shijian.equals("饭菜3min")){
                min = 3;
                sec = 0;
            }else if(shijian.equals("牛奶2min")){
                min = 2;
                sec = 0;
            }else if(shijian.equals("馒头1min")){
                min = 1;
                sec = 0;
            }
            int time = min * 60 + sec;
            String hour;
            String min;
            String sec;
            while(startFlag == 1 && time >= 0){
                hour = String.valueOf(time / 3600);
                if(hour.length() == 1){
                    hour = "0" + hour;
                }
                min = String.valueOf(((time - Integer.parseInt(hour) * 3600) / 60));
                if(min.length() == 1){
                    min = "0" + min;
                }
                sec = String.valueOf(time - Integer.parseInt(hour) * 3600 - Integer.parseInt(min) * 60);
                if(sec.length() == 1){
                    sec = "0" + sec;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                timeLabel.setText(hour + ":" + min + ":" + sec);
                time--;
            }
        }
    }

    class Stop implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(powerFlag == 0){
                return ;
            }
            startFlag = 0;
            min = 0;
            sec = 0;
            timeLabel.setText("00:00:00");
        }
    }

    class MinLister implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            min = (Integer)((JSpinner)e.getSource()).getValue();
            if(sec < 0 || min < 0){
                warning.setText("!!!");
            }else{
                warning.setText("");
            }
        }
    }

    class SecLister implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            sec = (Integer)((JSpinner)e.getSource()).getValue();
            if(sec < 0 || min < 0){
                warning.setText("!!!");
            }else{
                warning.setText("");
            }
        }
    }

    class StartLister implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(startLabel.getText().equals("开")){
                powerFlag = 0;
                startLabel.setText("关");
                startLabel.setBackground(Color.gray);
            }else{
                powerFlag = 1;
                startLabel.setText("开");
                startLabel.setBackground(Color.CYAN);
            }
        }
    }

    public static void main(String[] args) {
        new Microwave().setVisible(true);
    }
}
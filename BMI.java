package Cal;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class BMI extends JFrame implements ActionListener{

    private final String[] KEYS = {"7","8","9","4","5","6","1","2","3",".","0","确认"};
    private JButton keys[] = new JButton[KEYS.length];
    private JButton R= new JButton("开始计算");
    private JButton D= new JButton("Del");
    private JButton C= new JButton("Cal");
    private JButton T= new JButton("T");
    private JButton A= new JButton("AC");
    private JTextArea resultText = new JTextArea("");
    private JTextArea ageText = new JTextArea("");
    private JTextArea heightText = new JTextArea("");
    private JTextArea weightText = new JTextArea("");
    private JLabel label1 = new JLabel("年龄:");
    private JLabel label2 = new JLabel("身高(m):");
    private JLabel label3 = new JLabel("体重(kg):");
    private String b = "";

    public BMI(){
        super("BMI指数计算");
        Font font1 = new Font("华文彩云", Font.PLAIN, 15);
        Font font2 = new Font("黑体", Font.PLAIN, 23);
        Font font3 = new Font("黑体", Font.PLAIN, 18);
        label1.setBounds(20, 18, 70, 60);
        label2.setBounds(20, 88, 70, 60);
        label3.setBounds(20, 158, 70, 60);
        label1.setFont(font1);
        label2.setFont(font1);
        label3.setFont(font1);

        R.setBounds(20, 236, 230, 60);
        A.setBounds(497, 48, 60, 50);
        C.setBounds(497, 113, 60, 50);
        T.setBounds(497, 178, 60, 50);
        D.setBounds(497, 243, 60, 50);
        R.setFont(font1);
        T.setFont(font3);
        R.setBackground(Color.GRAY);
        A.setBackground(Color.LIGHT_GRAY);
        C.setBackground(Color.LIGHT_GRAY);
        D.setBackground(Color.LIGHT_GRAY);
        T.setBackground(Color.LIGHT_GRAY);
        T.setForeground(Color.black);

        ageText.setBounds(100,38,120,40);
        heightText.setBounds(100,108,120,40);
        weightText.setBounds(100,178,120,40);
        ageText.setFont(font1);
        heightText.setFont(font1);
        weightText.setFont(font1);

        resultText.setBounds(20,300,471,120);
        resultText.setEditable(false);// 文本框不允许修改结果
        resultText.setBackground(Color.LIGHT_GRAY);
        resultText.setAlignmentX(LEFT_ALIGNMENT);
        resultText.setFont(font2);

        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(A);
        this.add(C);
        this.add(D);
        this.add(R);
        this.add(T);
        this.add(ageText);
        this.add(weightText);
        this.add(heightText);
        this.add(resultText);

        this.setLayout(null);
        this.setResizable(false);
        this.setBounds(500, 200, 573, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        int x = 255, y = 38;
        for (int i = 0; i < KEYS.length; i++)
        {
            keys[i] = new JButton();
            keys[i].setText(KEYS[i]);
            keys[i].setBackground(Color.LIGHT_GRAY);
            keys[i].setForeground(Color.gray);
            keys[i].setFont(font2);
            keys[i].setBounds(x, y, 75, 60);
            if (x < 350) {
                x += 80;
            } else {
                x = 255;
                y += 66;
            }
            this.add(keys[i]);
        }
        keys[11].setFont(font1);
        // 每个按钮都注册事件监听器
        for (int i = 0; i < KEYS.length; i++){
            keys[i].addActionListener(this);
        }
        A.addActionListener(this);
        C.addActionListener(this);
        D.addActionListener(this);
        R.addActionListener(this);
        T.addActionListener(this);

    }
    int n=0;
    // 事件处理
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        if (Objects.equals(label, "确认")) {
            n++;
            label = "";
            this.b = "";
        }
        if (Objects.equals(label, "开始计算")) {
            n++;
            String s =weightText.getText();
            String l = heightText.getText();
            ns(s,l);
        }
        //利用确认键 实现数字在年龄、身高、体重文本框的显示
        if (n == 0) {
            this.b = this.b + label;
            ageText.setText(this.b);
        }
        if (n == 1) {
            this.b = this.b + label;
            heightText.setText(this.b);
        } else if (n == 2) {
            this.b = this.b + label;
            weightText.setText(this.b);
        }
        if(Objects.equals(label, "AC"))//清空按钮，消除所有文本框前面所有的输入和结果
        {
            this.b="";
            ageText.setText("");
            weightText.setText("");
            heightText.setText("");
            n=0;
        }
        else if(Objects.equals(label,"Del")){
            this.b=b.substring(0,b.length()-4);
            if (n == 0) {
                ageText.setText(this.b);
            }
            if (n == 1) {
                heightText.setText(this.b);
            } else if (n == 2) {
                weightText.setText(this.b);
            }
        }
        //界面转换到计算器界面
        else if(Objects.equals(label,"Cal")){
            this.dispose();
            JFrame frame = new Calculator();
        }
        //界面转换到温度转换界面
        else if(Objects.equals(label,"T")){
            this.dispose();
            JFrame frame = new Temperature();
        }
    }
    //计算BMI值
    public void ns(String s,String l){
        double y=Double.parseDouble(s);
        double z=Double.parseDouble(l);
        double a = y/(z*z);
        Double w = Double.valueOf(String.format("%.2f", a ));
        if(w<18.5){
            resultText.setText("\n"+"\t"+"  你的BMI值为"+w+"\n"+"\t"+"你的健康状况为：偏瘦");
        }
        else if(w<23.9){
            resultText.setText("\n"+"\t"+"  你的BMI值为"+w+"\n"+"\t"+"你的健康状况为：正常");
        }
        else if(w<28){
            resultText.setText("\n"+"\t"+"  你的BMI值为"+w+"\n"+"\t"+"你的健康状况为：偏胖");
        }
        else{
            resultText.setText("\n"+"\t"+"  你的BMI值为"+w+"\n"+"\t"+"你的健康状况为：肥胖");
        }
    }
    // 主函数
    public static void main(String[] args) {
        BMI a = new BMI();
    }

}





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class p extends JPanel implements KeyListener, ActionListener {
    ImageIcon title=new ImageIcon("G://1.jpg");
    ImageIcon tl=new ImageIcon("G://tl.png");
    ImageIcon tr=new ImageIcon("G://tr.png");
    ImageIcon tu=new ImageIcon("G://tu.png");
    ImageIcon td=new ImageIcon("G://td.png");
    ImageIcon s=new ImageIcon("G://s.png");
    ImageIcon f1=new ImageIcon("G://f1.png");
    ImageIcon f2=new ImageIcon("G://f2.png");
    ImageIcon f3=new ImageIcon("G://f3.png");
    ImageIcon f4=new ImageIcon("G://f4.png");
    ImageIcon f5=new ImageIcon("G://f5.png");

    int len=3;
    int score=0;
    int[] x=new int[800];
    int[] y=new int [900];
    String fx="R";
    boolean isStarted = false;
    boolean isFailed = false;
    Timer t=new Timer(100,this);
    int fox1;
    int foy1;
    int fox2;
    int foy2;
    int fox3;
    int foy3;
    int fox4;
    int foy4;
    int fox5;
    int foy5;
    Random rand = new Random();

    public p(){
        initUI();
        this.setFocusable(true);//获取键盘事件
        this.addKeyListener(this);//处理键盘事件
        cSnake();
        t.start();
    }

    public void initUI() {
        //在initUI中实例化JFrame类的对象
        JFrame frame = new JFrame();
        //设置窗体对象的属性值
        frame.setTitle("贪吃蛇小游戏登录");//设置窗体标题
        frame.setSize(400, 250);//设置窗体大小，只对顶层容器生效
        frame.setDefaultCloseOperation(3);//设置窗体关闭操作，3表示关闭窗体退出程序
        frame.setLocationRelativeTo(null);//设置窗体相对于另一组间的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(false);//禁止调整窗体大小
        frame.setFont(new Font("宋体",Font.PLAIN,14));//设置字体，显示格式正常，大小

        //实例化FlowLayout流式布局类的对象，指定对齐方式为居中对齐组件之间的间隔为10个像素
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER,10,10);
        //实例化流式布局类的对象
        frame.setLayout(fl);

        //实例化JLabel标签对象，该对象显示“账号”
        JLabel labname = new JLabel("账号：");
        labname.setFont(new Font("宋体",Font.PLAIN,14));
        //将labname标签添加到窗体上
        frame.add(labname);

        //实例化JTextField标签对象化
        JTextField text_name = new JTextField();
        Dimension dim1 = new Dimension(300,30);
        text_name.setPreferredSize(dim1);//设置除顶级容器组件以外其他组件的大小
        //将textName标签添加到窗体上
        frame.add(text_name);

        //实例化JLabel标签对象，该对象显示“密码”
        JLabel labpass = new JLabel("密码：");
        labpass.setFont(new Font("宋体",Font.PLAIN,14));
        //将labpass添加到窗体上
        frame.add(labpass);

        //实例化JPasswordField
        JPasswordField text_password = new JPasswordField();
        //设置大小
        text_password.setPreferredSize(dim1);
        //添加到窗体
        frame.add(text_password);

        //实例化JButton组件
        JButton button1 = new JButton();
        //设置按键的显示内容
        Dimension dim2 = new Dimension(100,30);
        button1.setText("登录");
        button1.setFont(new Font("宋体",Font.PLAIN,14));
        //设置按键大小
        button1.setSize(dim2);
        frame.add(button1);

        frame.setVisible(true);//窗体可见，一定要放在所有组件加入窗体后

        LoginListener ll = new LoginListener(frame,text_name,text_password);
        button1.addActionListener(ll);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);//调用父类的画笔
        this.setBackground(Color.white);
        title.paintIcon(this,g,100,11);
        g.fillRect(25,200,850,600);
        g.setColor(Color.pink);
        g.drawString("长度:"+len,800,35);
        g.drawString("分数:"+score,800,50);

        if(fx == "R"){
            tr.paintIcon(this,g,x[0],y[0]);
        }
        else if(fx == "L"){
            tl.paintIcon(this,g,x[0],y[0]);
        }
        else if(fx == "U"){
            tu.paintIcon(this,g,x[0],y[0]);
        }
        else if(fx == "D"){
            td.paintIcon(this,g,x[0],y[0]);
        }

        for(int i =1;i<len;i++){
            s.paintIcon(this,g,x[i],y[i]);
        }

        f1.paintIcon(this,g,fox1,foy1);
        f2.paintIcon(this,g,fox2,foy2);
        f3.paintIcon(this,g,fox3,foy3);
        f4.paintIcon(this,g,fox4,foy4);
        f5.paintIcon(this,g,fox5,foy5);

        if(isStarted == false) {
            g.setColor(Color.magenta);
            Font chineseFont = new Font("黑体", Font.PLAIN,200);
            g.drawString("请按空格键开始！", 200, 300);
        }
        if(isFailed == true) {
            g.setColor(Color.CYAN);
            Font chineseFont = new Font("黑体", Font.PLAIN,200);
            g.drawString("失败!请按空格重新开始", 200, 400);
        }
    }

    public void cSnake() {
        len=3;
        x[0]=70;
        y[0]=210;
        x[1]=55;
        y[1]=210;
        x[2]=40;
        y[2]=210;
        fox1=40+15*rand.nextInt(50);
        foy1=210+15*rand.nextInt(24);
        fox2=40+15*rand.nextInt(50);
        foy2=210+15*rand.nextInt(24);
        fox3=40+15*rand.nextInt(50);
        foy3=210+15*rand.nextInt(24);
        fox4=40+15*rand.nextInt(50);
        foy4=210+15*rand.nextInt(24);
        fox5=40+15*rand.nextInt(50);
        foy5=210+15*rand.nextInt(24);
        fx="R";
        score=0;
    }

    public void keyPressed(KeyEvent e){
       int keyCode=e.getKeyCode();
       if(keyCode == KeyEvent.VK_SPACE){
           if(isFailed){
               isFailed=false;
               cSnake();
           }else {
               isStarted = !isStarted;//判断输入是否为空格键
           }
            repaint();
       }else if(keyCode == KeyEvent.VK_LEFT){
            fx="L";
       }else if(keyCode == KeyEvent.VK_RIGHT){
           fx="R";
       }else if(keyCode == KeyEvent.VK_UP){
           fx="U";
       }else if(keyCode == KeyEvent.VK_DOWN){
           fx="D";
       }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e){
    }

    public void actionPerformed(ActionEvent e) {
        if (isStarted && !isFailed) {
            for (int i = len - 1; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            if(fx=="R") {
                x[0] = x[0] + 15;
                if (x[0] > 850) x[0] = 15;
            }else if(fx=="L"){
                x[0] = x[0] - 15;
                if (x[0] < 15) x[0] = 850;
            }else if(fx=="U"){
                y[0] = y[0] - 15;
                if (y[0] < 210) y[0] = 600;
            }else if(fx=="D"){
                y[0] = y[0] + 15;
                if (y[0] > 600 ) y[0] = 210;
            }

            if(x[0] == fox1 && y[0]==foy1){
                len++;
                score =score+10;
                fox1=40+15*rand.nextInt(43);
                foy1=210+15*rand.nextInt(24);
            }

            if(x[0] == fox2 && y[0]==foy2){
                len++;
                score =score+30;
                fox2=40+15*rand.nextInt(43);
                foy2=210+15*rand.nextInt(24);
            }

            if(x[0] == fox3 && y[0]==foy3){
                len++;
                score =score+20;
                fox3=40+15*rand.nextInt(43);
                foy3=210+15*rand.nextInt(24);
            }

            if(x[0] == fox4 && y[0]==foy4){
                len++;
                score =score+50;
                fox4=40+15*rand.nextInt(43);
                foy4=210+15*rand.nextInt(24);
            }

            if(x[0] == fox5 && y[0]==foy5){
                len++;
                score =score+40;
                fox5=40+15*rand.nextInt(43);
                foy5=210+15*rand.nextInt(24);
            }

            for(int i =1;i<len;i++){
                if(x[i]==x[0] && y[i]==y[0]){
                    isFailed=true;
                }
            }
            repaint();
        }
      t.start();
    }
}
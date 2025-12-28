import javax.swing.JFrame;

public class y {
    public static void main(String[] args){
      JFrame f=new JFrame();//设置页面
      f.setBounds(10,10,900,1000);//设置页面坐标，长宽
      f.setResizable(false);  //不能手动更改
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.add(new p());
      f.setVisible(true);//可视化
    }
}
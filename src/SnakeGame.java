import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;

public class SnakeGame {
    private static int score = 100;

    public static void main(String[] args) {
        // 游戏逻辑代码

        // 游戏结束后记录分数并弹出数据
        recordScore();
        showScore();
    }

    private static void recordScore() {
        String playerName = JOptionPane.showInputDialog("请输入账号：");

        // 将玩家姓名和分数写入文件
        try {
            FileWriter writer = new FileWriter("记录.txt", true);
            writer.write(playerName + " " + score + "\n");
            writer.close();
            System.out.println("记录已保存");
        } catch (IOException e) {
            System.out.println("保存记录时出错：" + e.getMessage());
        }
    }

    private static void showScore() {
        JOptionPane.showMessageDialog(null, "您的分数是：" + score);
    }
}

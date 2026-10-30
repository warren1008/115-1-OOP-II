import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// 課堂練習：依 GUI_Draw 講義的座標，在 400 × 400 畫布畫機器人。
public class RobotPractice extends JPanel {
    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 1. 兩條黑色天線，先畫線，圓形和頭部再蓋在接點上。
        g.setColor(Color.BLACK);
        g.drawLine(150, 60, 120, 20);
        g.drawLine(250, 60, 280, 20);

        // 2. 兩個紅色天線頂端，寬和高相同，所以是正圓。
        g.setColor(Color.RED);
        g.fillOval(110, 10, 20, 20);
        g.fillOval(270, 10, 20, 20);

        // 3. 淺灰色圓角頭部：先填色，再畫黑色外框。
        g.setColor(Color.LIGHT_GRAY);
        g.fillRoundRect(100, 60, 200, 180, 40, 40);
        g.setColor(Color.BLACK);
        g.drawRoundRect(100, 60, 200, 180, 40, 40);

        // 4. 白色眼白。
        g.setColor(Color.WHITE);
        g.fillOval(130, 100, 50, 40);
        g.fillOval(220, 100, 50, 40);

        // 5. 藍色眼珠。
        g.setColor(Color.BLUE);
        g.fillOval(145, 110, 20, 20);
        g.fillOval(235, 110, 20, 20);

        // 6. 深灰色嘴巴。
        g.setColor(Color.DARK_GRAY);
        g.fillRect(150, 180, 100, 30);

        // 7. 用 for 迴圈畫四條白色牙齒分隔線。
        g.setColor(Color.WHITE);
        for (int x = 170; x <= 230; x += 20) {
            g.drawLine(x, 180, x, 210);
        }

        // 8. 橘色身體與黑色外框。
        g.setColor(Color.ORANGE);
        g.fillRect(130, 250, 140, 120);
        g.setColor(Color.BLACK);
        g.drawRect(130, 250, 140, 120);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("課堂練習：我的機器人");
            RobotPractice panel = new RobotPractice();
            panel.setPreferredSize(new Dimension(400, 400));
            panel.setBackground(new Color(238, 238, 238));
            frame.add(panel);
            // pack 依畫布的偏好大小配置視窗，標題列不占用畫布空間。
            frame.pack();
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

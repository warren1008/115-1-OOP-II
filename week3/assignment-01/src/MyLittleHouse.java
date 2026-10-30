import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// 回家作業：用基本 Graphics 方法，在 500 × 400 畫布畫小房子。
public class MyLittleHouse extends JPanel {
    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        // 使用 2 像素線寬，讓屋頂、房屋外框與十字窗框清楚顯示。
        g.setStroke(new BasicStroke(2));

        // 1. 天空與草地：畫布的上、下半部各高 200。
        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, 500, 200);
        g.setColor(new Color(115, 184, 87));
        g.fillRect(0, 200, 500, 200);

        // 2. 太陽：直徑 60 的黃色正圓，以及 12 條放射狀光芒。
        g.setColor(Color.YELLOW);
        g.fillOval(65, 45, 60, 60);
        int centerX = 95;
        int centerY = 75;
        for (int i = 0; i < 12; i++) {
            double angle = Math.toRadians(i * 30);
            int x1 = centerX + (int) Math.round(40 * Math.cos(angle));
            int y1 = centerY + (int) Math.round(40 * Math.sin(angle));
            int x2 = centerX + (int) Math.round(53 * Math.cos(angle));
            int y2 = centerY + (int) Math.round(53 * Math.sin(angle));
            g.drawLine(x1, y1, x2, y2);
        }

        // 3. 雲朵：三個互相重疊的白色橢圓。
        g.setColor(Color.WHITE);
        g.fillOval(195, 48, 65, 32);
        g.fillOval(225, 32, 75, 48);
        g.fillOval(265, 48, 65, 32);

        // 4. 房屋主體：米黃色填色，加上深棕色外框。
        g.setColor(new Color(255, 230, 180));
        g.fillRect(140, 200, 220, 145);
        g.setColor(new Color(95, 60, 40));
        g.drawRect(140, 200, 220, 145);

        // 5. 三角形屋頂：依題意只用三條 drawLine，不填色。
        g.setColor(new Color(160, 70, 40));
        g.drawLine(125, 200, 250, 120);
        g.drawLine(250, 120, 375, 200);
        g.drawLine(375, 200, 125, 200);

        // 6. 圓角門和圓形門把。
        g.setColor(new Color(145, 90, 55));
        g.fillRoundRect(227, 265, 46, 80, 14, 14);
        g.setColor(Color.YELLOW);
        g.fillOval(260, 307, 6, 6);

        // 7. 兩扇窗戶：填色、外框，再畫水平與垂直的十字窗框。
        g.setColor(new Color(190, 230, 250));
        g.fillRect(166, 230, 46, 45);
        g.fillRect(288, 230, 46, 45);
        g.setColor(new Color(95, 60, 40));
        g.drawRect(166, 230, 46, 45);
        g.drawRect(288, 230, 46, 45);
        g.drawLine(189, 230, 189, 275);
        g.drawLine(166, 252, 212, 252);
        g.drawLine(311, 230, 311, 275);
        g.drawLine(288, 252, 334, 252);

        // 8. 右下角簽名；drawString 的 y 座標是文字基準線。
        g.setColor(Color.BLACK);
        g.setFont(new Font("SansSerif", Font.PLAIN, 14));
        g.drawString("A1123307 黃品勛", 350, 385);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("回家作業：我的小房子");
            MyLittleHouse panel = new MyLittleHouse();
            panel.setPreferredSize(new Dimension(500, 400));
            frame.add(panel);
            frame.pack();
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

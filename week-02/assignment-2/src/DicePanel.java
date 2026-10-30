import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public final class DicePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    // 0 表示尚未擲骰子，此時只畫外框。
    private int point = 0;

    public DicePanel() {
        setPreferredSize(new Dimension(140, 140));
        setForeground(Color.BLACK);
    }

    public void setPoint(int point) {
        this.point = point;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        // 先清除上一次的圖案，避免圓點殘留。
        super.paintComponent(graphics);

        int side = Math.min(120, Math.min(getWidth(), getHeight()) - 20);
        if (side < 30) {
            return;
        }
        int x = (getWidth() - side) / 2;
        int y = (getHeight() - side) / 2;

        Graphics2D g = (Graphics2D) graphics.create();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.WHITE);
        g.fillRoundRect(x, y, side, side, 20, 20);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, side, side, 20, 20);

        int left = x + side / 4;
        int center = x + side / 2;
        int right = x + side * 3 / 4;
        int top = y + side / 4;
        int middle = y + side / 2;
        int bottom = y + side * 3 / 4;
        int dotSize = side / 8;

        g.setColor(getForeground());

        // 1、3、5 的正中央都有一點。
        if (point == 1 || point == 3 || point == 5) {
            drawDot(g, center, middle, dotSize);
        }

        // 2 到 6 都有左上與右下兩點。
        if (point >= 2) {
            drawDot(g, left, top, dotSize);
            drawDot(g, right, bottom, dotSize);
        }

        // 4、5、6 再補上右上與左下兩點。
        if (point >= 4) {
            drawDot(g, right, top, dotSize);
            drawDot(g, left, bottom, dotSize);
        }

        // 6 最後補上左右兩側中間的兩點。
        if (point == 6) {
            drawDot(g, left, middle, dotSize);
            drawDot(g, right, middle, dotSize);
        }

        g.dispose();
    }

    private void drawDot(Graphics g, int centerX, int centerY, int size) {
        g.fillOval(centerX - size / 2, centerY - size / 2, size, size);
    }
}

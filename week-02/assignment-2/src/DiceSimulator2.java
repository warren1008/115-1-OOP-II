import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public final class DiceSimulator2 extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private final JLabel statisticsLabel;
    private final JLabel numberLabel;
    private final JButton rollButton;
    private final DicePanel dicePanel;
    private final Random random;

    private int rollCount;
    private int total;

    public DiceSimulator2() {
        random = new Random();
        rollCount = 0;
        total = 0;

        statisticsLabel = new JLabel("已擲 0 次，總和 0，平均 0.00", SwingConstants.CENTER);

        numberLabel = new JLabel("—", SwingConstants.CENTER);
        numberLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
        numberLabel.setForeground(Color.BLACK);

        dicePanel = new DicePanel();
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(numberLabel, BorderLayout.NORTH);
        centerPanel.add(dicePanel, BorderLayout.CENTER);

        rollButton = new JButton("擲骰子");

        // 事件來源是 rollButton；this 是實作 ActionListener 的視窗物件。
        rollButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(rollButton);

        setLayout(new BorderLayout());
        add(statisticsLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // 按下按鈕時，Swing 會呼叫事件傾聽者的這個方法。
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == rollButton) {
            rollDice();
        }
    }

    private void rollDice() {
        int point = random.nextInt(6) + 1;
        rollCount++;
        total += point;

        // 先轉成 double，避免整數除法捨去小數。
        double average = (double) total / rollCount;
        statisticsLabel.setText(String.format(
                Locale.TAIWAN, "已擲 %d 次，總和 %d，平均 %.2f", rollCount, total, average));
        numberLabel.setText(String.valueOf(point));

        Color pointColor;
        if (point == 1) {
            pointColor = Color.RED;
        } else if (point == 6) {
            pointColor = Color.GREEN;
        } else {
            pointColor = Color.BLACK;
        }

        numberLabel.setForeground(pointColor);
        dicePanel.setForeground(pointColor);

        // 更新圖案的點數；setPoint() 會呼叫 repaint()，請 Swing 重畫。
        dicePanel.setPoint(point);
    }

    public static void main(String[] args) {
        // 在 Swing 的事件派送執行緒建立並顯示介面。
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DiceSimulator2 window = new DiceSimulator2();
                window.setVisible(true);
            }
        });
    }
}

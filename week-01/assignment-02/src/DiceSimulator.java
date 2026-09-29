import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class DiceSimulator extends JFrame {
    private static final long serialVersionUID = 1L;

    private final JLabel statisticsLabel;
    private final JLabel diceLabel;
    private final Random random;

    private int rollCount;
    private int total;

    public DiceSimulator() {
        random = new Random();
        rollCount = 0;
        total = 0;

        statisticsLabel = new JLabel("已擲 0 次，總和 0，平均 0.00", SwingConstants.CENTER);

        diceLabel = new JLabel("—", SwingConstants.CENTER);
        diceLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
        diceLabel.setForeground(Color.BLACK);

        JButton rollButton = new JButton("擲骰子");
        rollButton.addActionListener(event -> rollDice());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(rollButton);

        setLayout(new BorderLayout());
        add(statisticsLabel, BorderLayout.NORTH);
        add(diceLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void rollDice() {
        int point = random.nextInt(6) + 1;
        rollCount++;
        total += point;

        diceLabel.setText(String.valueOf(point));
        updateDiceColor(point);

        double average = (double) total / rollCount;
        statisticsLabel.setText(
                String.format("已擲 %d 次，總和 %d，平均 %.2f", rollCount, total, average));
    }

    private void updateDiceColor(int point) {
        if (point == 6) {
            diceLabel.setForeground(Color.GREEN);
        } else if (point == 1) {
            diceLabel.setForeground(Color.RED);
        } else {
            diceLabel.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DiceSimulator window = new DiceSimulator();
            window.setVisible(true);
        });
    }
}

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class UnitConverter extends JFrame {
    private static final long serialVersionUID = 1L;

    private static final String[] CATEGORIES = {"長度", "重量", "溫度"};
    private static final String[] LENGTH_UNITS = {"公尺", "公分", "英吋", "英尺"};
    private static final String[] WEIGHT_UNITS = {"公斤", "公克", "磅", "盎司"};
    private static final String[] TEMPERATURE_UNITS = {"攝氏", "華氏", "克氏"};

    private final JComboBox<String> categoryComboBox;
    private final JComboBox<String> sourceUnitComboBox;
    private final JComboBox<String> targetUnitComboBox;
    private final JTextField sourceField;
    private final JTextField targetField;
    private final JButton convertButton;
    private final JLabel messageLabel;

    public UnitConverter() {
        categoryComboBox = new JComboBox<>(CATEGORIES);
        sourceUnitComboBox = new JComboBox<>();
        targetUnitComboBox = new JComboBox<>();
        sourceField = new JTextField(16);
        targetField = new JTextField(16);
        convertButton = new JButton("換算");
        messageLabel = new JLabel("請輸入數值後按下換算", SwingConstants.CENTER);

        targetField.setEditable(false);

        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 12));
        categoryPanel.add(new JLabel("換算類型："));
        categoryPanel.add(categoryComboBox);

        JPanel sourcePanel = createValuePanel("來源數值：", sourceField, sourceUnitComboBox);
        JPanel targetPanel = createValuePanel("換算結果：", targetField, targetUnitComboBox);

        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 0, 8));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        centerPanel.add(sourcePanel);
        centerPanel.add(targetPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(convertButton);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 20));
        southPanel.add(buttonPanel, BorderLayout.NORTH);
        southPanel.add(messageLabel, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(categoryPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        categoryComboBox.addActionListener(event -> updateUnitChoices());
        convertButton.addActionListener(event -> convertInput());
        sourceField.addActionListener(event -> convertInput());

        updateUnitChoices();

        setTitle("單位換算器");
        setSize(480, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getRootPane().setDefaultButton(convertButton);
    }

    private JPanel createValuePanel(
            String labelText, JTextField textField, JComboBox<String> unitComboBox) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        panel.add(new JLabel(labelText));
        panel.add(textField);
        panel.add(unitComboBox);
        return panel;
    }

    private void updateUnitChoices() {
        String category = (String) categoryComboBox.getSelectedItem();
        String[] units = getUnits(category);

        sourceUnitComboBox.removeAllItems();
        targetUnitComboBox.removeAllItems();

        for (String unit : units) {
            sourceUnitComboBox.addItem(unit);
            targetUnitComboBox.addItem(unit);
        }

        sourceUnitComboBox.setSelectedIndex(0);
        targetUnitComboBox.setSelectedIndex(1);
        targetField.setText("");
        messageLabel.setText("請輸入數值後按下換算");
    }

    private String[] getUnits(String category) {
        if ("重量".equals(category)) {
            return WEIGHT_UNITS;
        }
        if ("溫度".equals(category)) {
            return TEMPERATURE_UNITS;
        }
        return LENGTH_UNITS;
    }

    private void convertInput() {
        String input = sourceField.getText().trim();

        if (input.isEmpty()) {
            targetField.setText("");
            messageLabel.setText("請輸入要換算的數值");
            return;
        }

        try {
            double value = Double.parseDouble(input);

            if (!Double.isFinite(value)) {
                throw new NumberFormatException();
            }

            String category = (String) categoryComboBox.getSelectedItem();
            String sourceUnit = (String) sourceUnitComboBox.getSelectedItem();
            String targetUnit = (String) targetUnitComboBox.getSelectedItem();
            double result = convertValue(category, value, sourceUnit, targetUnit);

            DecimalFormat format = new DecimalFormat("0.##########");
            targetField.setText(format.format(result));
            messageLabel.setText("換算完成");
        } catch (NumberFormatException exception) {
            targetField.setText("");
            messageLabel.setText("請輸入有效的數字");
        }
    }

    public static double convertValue(
            String category, double value, String sourceUnit, String targetUnit) {
        if ("長度".equals(category)) {
            return convertLength(value, sourceUnit, targetUnit);
        }
        if ("重量".equals(category)) {
            return convertWeight(value, sourceUnit, targetUnit);
        }
        if ("溫度".equals(category)) {
            return convertTemperature(value, sourceUnit, targetUnit);
        }
        throw new IllegalArgumentException("未知的換算類型：" + category);
    }

    private static double convertLength(double value, String sourceUnit, String targetUnit) {
        double meters;

        if ("公分".equals(sourceUnit)) {
            meters = value / 100.0;
        } else if ("英吋".equals(sourceUnit)) {
            meters = value * 0.0254;
        } else if ("英尺".equals(sourceUnit)) {
            meters = value * 0.3048;
        } else {
            meters = value;
        }

        if ("公分".equals(targetUnit)) {
            return meters * 100.0;
        }
        if ("英吋".equals(targetUnit)) {
            return meters / 0.0254;
        }
        if ("英尺".equals(targetUnit)) {
            return meters / 0.3048;
        }
        return meters;
    }

    private static double convertWeight(double value, String sourceUnit, String targetUnit) {
        double kilograms;

        if ("公克".equals(sourceUnit)) {
            kilograms = value / 1000.0;
        } else if ("磅".equals(sourceUnit)) {
            kilograms = value * 0.45359237;
        } else if ("盎司".equals(sourceUnit)) {
            kilograms = value * 0.028349523125;
        } else {
            kilograms = value;
        }

        if ("公克".equals(targetUnit)) {
            return kilograms * 1000.0;
        }
        if ("磅".equals(targetUnit)) {
            return kilograms / 0.45359237;
        }
        if ("盎司".equals(targetUnit)) {
            return kilograms / 0.028349523125;
        }
        return kilograms;
    }

    private static double convertTemperature(
            double value, String sourceUnit, String targetUnit) {
        double celsius;

        if ("華氏".equals(sourceUnit)) {
            celsius = (value - 32.0) * 5.0 / 9.0;
        } else if ("克氏".equals(sourceUnit)) {
            celsius = value - 273.15;
        } else {
            celsius = value;
        }

        if ("華氏".equals(targetUnit)) {
            return celsius * 9.0 / 5.0 + 32.0;
        }
        if ("克氏".equals(targetUnit)) {
            return celsius + 273.15;
        }
        return celsius;
    }

    private static void runSelfTest() {
        try {
            SwingUtilities.invokeAndWait(() -> {
                UnitConverter window = new UnitConverter();

                try {
                    check(window.getWidth() == 480 && window.getHeight() == 280,
                            "視窗尺寸應為 480 × 280");
                    check(window.getLayout() instanceof BorderLayout,
                            "視窗應使用 BorderLayout");
                    check(window.categoryComboBox.getItemCount() == 3,
                            "換算類型應有三個選項");
                    check(window.sourceUnitComboBox.getItemCount() == 4,
                            "長度應有四個單位選項");

                    window.sourceField.setText("1");
                    window.sourceUnitComboBox.setSelectedItem("公尺");
                    window.targetUnitComboBox.setSelectedItem("公分");
                    window.convertButton.doClick();
                    check("100".equals(window.targetField.getText()),
                            "1 公尺應等於 100 公分");

                    window.categoryComboBox.setSelectedItem("重量");
                    check(window.sourceUnitComboBox.getItemCount() == 4,
                            "重量應有四個單位選項");
                    check("公斤".equals(window.sourceUnitComboBox.getItemAt(0)),
                            "切換類型時來源單位應更新");
                    check("公克".equals(window.targetUnitComboBox.getItemAt(1)),
                            "切換類型時目標單位應更新");
                    window.sourceField.setText("1");
                    window.sourceUnitComboBox.setSelectedItem("公斤");
                    window.targetUnitComboBox.setSelectedItem("磅");
                    window.convertButton.doClick();
                    checkClose(Double.parseDouble(window.targetField.getText()),
                            2.2046226218, 0.0000000001, "公斤轉磅");

                    window.categoryComboBox.setSelectedItem("溫度");
                    check(window.sourceUnitComboBox.getItemCount() == 3,
                            "溫度應有三個單位選項");
                    window.sourceField.setText("100");
                    window.sourceUnitComboBox.setSelectedItem("攝氏");
                    window.targetUnitComboBox.setSelectedItem("華氏");
                    window.convertButton.doClick();
                    check("212".equals(window.targetField.getText()),
                            "100 攝氏應等於 212 華氏");

                    window.sourceField.setText("273.15");
                    window.sourceUnitComboBox.setSelectedItem("克氏");
                    window.targetUnitComboBox.setSelectedItem("攝氏");
                    window.convertButton.doClick();
                    check("0".equals(window.targetField.getText()),
                            "273.15 克氏應等於 0 攝氏");

                    window.sourceField.setText("abc");
                    window.convertButton.doClick();
                    check(window.targetField.getText().isEmpty(),
                            "錯誤輸入不應留下換算結果");
                    check("請輸入有效的數字".equals(window.messageLabel.getText()),
                            "錯誤輸入應顯示提示訊息");

                    checkClose(convertValue("長度", 12.0, "英吋", "英尺"),
                            1.0, 0.0000000001, "英吋轉英尺");
                    checkClose(convertValue("重量", 16.0, "盎司", "磅"),
                            1.0, 0.0000000001, "盎司轉磅");
                    checkClose(convertValue("溫度", 32.0, "華氏", "攝氏"),
                            0.0, 0.0000000001, "華氏轉攝氏");
                } finally {
                    window.dispose();
                }
            });

            System.out.println("所有介面與換算測試皆通過。");
        } catch (Exception exception) {
            throw new RuntimeException("自我測試失敗", exception);
        }
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void checkClose(
            double actual, double expected, double tolerance, String testName) {
        if (Math.abs(actual - expected) > tolerance) {
            throw new AssertionError(
                    testName + "錯誤，預期 " + expected + "，實際 " + actual);
        }
    }

    public static void main(String[] args) {
        if (args.length > 0 && "--test".equals(args[0])) {
            runSelfTest();
            return;
        }

        SwingUtilities.invokeLater(() -> {
            UnitConverter window = new UnitConverter();
            window.setVisible(true);
        });
    }
}

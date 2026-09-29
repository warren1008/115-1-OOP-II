import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class LoginWindow extends JFrame implements ActionListener {
    private final JTextField accountField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JLabel messageLabel;

    public LoginWindow() {
        setTitle("登入");
        setSize(340, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));

        accountField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("登入");
        messageLabel = new JLabel("請輸入帳號和密碼", SwingConstants.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 8, 8));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 5, 30));
        inputPanel.add(new JLabel("帳號："));
        inputPanel.add(accountField);
        inputPanel.add(new JLabel("密碼："));
        inputPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(loginButton);

        JPanel southPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 15, 30));
        southPanel.add(buttonPanel);
        southPanel.add(messageLabel);

        add(inputPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(this);
        getRootPane().setDefaultButton(loginButton);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String account = accountField.getText().trim();
        String password = String.valueOf(passwordField.getPassword());

        if (account.isEmpty() || password.isEmpty()) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("請完整輸入帳號和密碼");
        } else if (account.equals("admin") && password.equals("1234")) {
            messageLabel.setForeground(new Color(0, 128, 0));
            messageLabel.setText("登入成功");
        } else {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("帳號或密碼錯誤");
            passwordField.setText("");
            passwordField.requestFocusInWindow();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginWindow::new);
    }
}

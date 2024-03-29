import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
    private JPanel panel1;
    private JPasswordField pas;
    private JButton btn;
    private JLabel catlabel;
    private JLabel guard;

    public LoginPage() {
        setTitle("Login");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450, 350));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        catlabel.setIcon(new ImageIcon("src/main/resources/img/twotone_vpn_key_white_48dp.png"));
        setResizable(false);

        setVisible(true);

        btn.addActionListener(e -> {
            String pasword = pas.getText();

            if (pasword.equals("yana")) {
                dispose();
                addPerson person = new addPerson();
            } else if (pasword.equals("admin")) {
                dispose();
                AdminPage admin = new AdminPage();

            } else {
                JOptionPane.showMessageDialog(LoginPage.this, "Wrong password!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        try {
            new Requests();
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new JMarsDarkTheme()));
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        LoginPage log = new LoginPage();
    }
}
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;
import mdlaf.themes.MaterialLiteTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginPage extends JFrame{
    private JPanel panel1;
    private JPasswordField pas;
    private JButton btn;
    private JLabel catlabel;

    public LoginPage ()
    {
        setTitle("Login");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,475));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        catlabel.setIcon(new ImageIcon("/home/qna/Desktop/fatcat128.png"));
        setVisible(true);
        //String pasword= Arrays.toString(pas.getPassword());

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pasword= pas.getText();
                System.out.println(pasword);
                if(pasword.equals("yana"))
                {
                    //vqrno i otvarq nov prozorec
                }else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Wrong password!",
                            "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new JMarsDarkTheme()));
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        LoginPage log = new LoginPage();
    }
}

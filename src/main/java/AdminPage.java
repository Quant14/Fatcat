import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class AdminPage extends JFrame{
    private JPanel panel1;
    private JPanel adminPanel;
    private JButton OKButton;
    private JTextField tf1;
    private JTextField tf2;
    private JButton delete;

    public AdminPage()
    {
        setTitle("Admin page");
        setContentPane(adminPanel);
        setMinimumSize(new Dimension(450,350));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tf1.getText().isEmpty()|| tf2.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(AdminPage.this,"You need to fill all the boxes",
                            "Problem", JOptionPane.ERROR_MESSAGE);
                }else {
                    Requests.setAdminSettings(tf2.getText(), tf1.getText());

                    JOptionPane.showMessageDialog(AdminPage.this, "All done!", "done",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Requests.deleteAllPersons();
                JOptionPane.showMessageDialog(AdminPage.this, "All people have been deleted!", "done",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
                exit(1);
            }
        });
    }

    /*public static void main(String[] args) {
        AdminPage admin = new AdminPage();
    }*/
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame{
    private AdminSettings stadium = new AdminSettings();
    private JPanel panel1;
    private JPanel adminPanel;
    private JButton OKButton;
    private JTextField tf1;
    private JTextField tf2;

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
                    stadium.sectors=tf1.getText();
                    stadium.guards=tf2.getText();
                    JOptionPane.showMessageDialog(AdminPage.this, "All done!", "done",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                
            }
        });
    }

    public static void main(String[] args) {
        AdminPage admin = new AdminPage();
    }
}

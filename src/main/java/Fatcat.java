import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class Fatcat extends JDialog{

    public Person person;
    private JLabel label;
    private JPanel panel2;
    private JPanel panel1;
    private JTextField tf1;
    private JLabel label2;
    private JButton but;
    private JButton but2;

    public Fatcat(JFrame parent, Person person)
    {
        super(parent);
        this.person=person;
        setTitle("Ne6ta");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,475));
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                person.name= tf1.getText();
                if(person.name.equals("yana")) {
                    JOptionPane.showMessageDialog(Fatcat.this, "You're in!",
                            "done", JOptionPane.INFORMATION_MESSAGE);
                    //setContentPane(panel1);
                } else
                {
                    JOptionPane.showMessageDialog(Fatcat.this, "stupid",
                            "not done", JOptionPane.ERROR_MESSAGE);
                    setVisible(false);
                    exit(1);
                }
            }
        });
        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                exit(1);
            }
        });
    }
    public static void main(String[] args) {
        Person p= new Person();
        Fatcat cat = new Fatcat(null, p);

    }
}

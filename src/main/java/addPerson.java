import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addPerson extends JDialog{

    Person person=new Person();
    private JPanel panel1;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JButton nextButton;
    private JButton doneButton;

    public addPerson()
    {
        setTitle("Add person");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,475));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        person.name=tf1.getText();
        person.sector=tf2.getText();
        person.description=tf3.getText();
        person.danger=tf4.getText();

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
            }
        });
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //otvarq nov prozorec
            }
        });
    }

    public static void main(String[] args) {
        addPerson add= new addPerson();
    }
}

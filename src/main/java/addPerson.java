import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addPerson extends JDialog{

    private Person person=new Person();
    private JPanel panel1;
    private JTextField tf1;
    private JTextField tf2;

    private JTextField tf4;
    private JButton nextButton;
    private JButton doneButton;
    private JTextArea ta1;

    public addPerson()
    {
        setTitle("Add person");
        setContentPane(panel1);
        setMinimumSize(new Dimension(500,450));
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setVisible(true);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tf1.getText().isEmpty() || tf2.getText().isEmpty() ||
                    ta1.getText().isEmpty() || tf4.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(addPerson.this, "Missing information!",
                            "Problem", JOptionPane.ERROR_MESSAGE);
                } else
                {
                    person.name=tf1.getText();
                    person.sector=tf2.getText();
                    person.description=ta1.getText();
                    person.danger=tf4.getText();
                    //pra6ta zaqvka i posle nulira poletata
                    JOptionPane.showMessageDialog(addPerson.this, "Person added!",
                            "Added", JOptionPane.INFORMATION_MESSAGE);
                    tf1.setText("");
                    tf2.setText("");
                    ta1.setText("");
                    tf4.setText("");
                }

            }
        });
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Graphics graphics= new Graphics();
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new JMarsDarkTheme()));
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        addPerson add= new addPerson();
    }
}

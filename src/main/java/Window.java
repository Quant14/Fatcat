import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{

    Person person= new Person();
    private JPanel panel1;
    private JButton okButton;
    private JButton btn2;

    public Window()
    {
        setTitle("window");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,475));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        btn2.setVisible(false);
        setVisible(true);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Fatcat pane= new Fatcat(null, person);
                //setVisible(true);
                btn2.setVisible(true);
            }

        });

    }

    public static void main(String[] args) {
        Window win= new Window();

    }
}

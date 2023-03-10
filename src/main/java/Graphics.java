import javax.swing.*;
import java.awt.*;

public class Graphics extends JFrame{
    private JPanel panel1;
    public Graphics()
    {
        setTitle("Graphics");
        setContentPane(panel1);
        setMinimumSize(new Dimension(450,475));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Graphics graphics= new Graphics();
    }
}

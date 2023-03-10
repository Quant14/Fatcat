//import org.knowm.xchart.XYChart;
import org.knowm.xchart.*;

import javax.swing.*;
import java.awt.*;

public class Graphics extends JFrame{
    private JPanel panel1;
    double[] xData = new double[] { 0.0, 1.0, 2.0 };
    double[] yData = new double[] { 2.0, 1.0, 0.0 };

    public Graphics ()
    {
        // Create Chart
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

        JPanel chartPanel = new XChartPanel<XYChart>(chart);
        add(chartPanel, BorderLayout.CENTER);

        setTitle("Graphics");
        setContentPane(chartPanel);
        setMinimumSize(new Dimension(450,475));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        chartPanel.setMaximumSize(new Dimension(400,400));
        chartPanel.setPreferredSize(new Dimension(400,400));
        chartPanel.setBackground(new Color(60,35,58));
        chartPanel.setForeground(new Color(60,35,58));
        chartPanel.setName("Graphic");

        setVisible(true);
        //new SwingWrapper(chart).displayChart();

    }

    public static void main(String[] args)  {
        Graphics graphics= new Graphics();
    }
}

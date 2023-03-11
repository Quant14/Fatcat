import org.knowm.xchart.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Graphics extends JFrame {
    private JPanel panel1;
    private ArrayList<Integer> sectors = new ArrayList<>();
    private ArrayList<Integer> guardsCnt = new ArrayList<>();

    private List<Integer> chartArray;

    public Graphics() {
        chartArray = Requests.processData();
        for (int i = 1; i <= chartArray.size(); i++) {
            sectors.add(i);
        }
        guardsCnt.addAll(chartArray);

        XYChart chart = QuickChart.getChart("", "Sector", "Guards", "guards per sector", sectors, guardsCnt);

        JPanel chartPanel = new XChartPanel<XYChart>(chart);
        add(chartPanel, BorderLayout.CENTER);

        setTitle("Guards per sector");
        setContentPane(chartPanel);
        setMinimumSize(new Dimension(600, 450));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        chartPanel.setMaximumSize(new Dimension(400, 400));
        chartPanel.setPreferredSize(new Dimension(400, 400));
        chartPanel.setBackground(new Color(60, 35, 58));
        chartPanel.setForeground(new Color(60, 35, 58));
        chartPanel.setName("Graphic");

        setVisible(true);
    }

    /*public static void main(String[] args) {
        Graphics graphics= new Graphics();
    }*/
}

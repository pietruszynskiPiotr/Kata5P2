package es.ulpgc.view;

import es.ulpgc.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

public class DisplayHistogram extends ApplicationFrame {

    private final Histogram<String> histogram;

    private final ChartPanel jPanel;

    public DisplayHistogram(String title, Histogram histogram) {
        super(title);
        jPanel = new ChartPanel(null);
        jPanel.setPreferredSize(new Dimension(500, 400));
        setContentPane(jPanel);
        this.histogram = histogram;
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public void execute() {;
        JFreeChart chart = createChart();
        jPanel.setChart(chart);
    }

    private JFreeChart createChart() {
        return ChartFactory.createBarChart("Histogram JFreeChart", "Dominios email", "N* de emails", createDataset(), PlotOrientation.VERTICAL, false, false, false);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        for (String  value : histogram.keySet()) {
            Integer integer = histogram.get(value);
            defaultCategoryDataset.addValue(integer, "", value);
        }
        return defaultCategoryDataset;
    }

}

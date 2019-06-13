package view;

import com.sun.xml.internal.ws.util.StringUtils;
import model.Statistic;
import model.StringRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Struct;
import java.util.List;
import java.util.List;

public class StatisticWindow {

    private static final String STATISTICS_RECORD_FORMAT = "%s. %-10s : %s";

    private JFrame viewStatistic;
    private JTabbedPane tabbedPane;

    public StatisticWindow() throws HeadlessException {
        viewStatistic = new JFrame("Рекорды");
        viewStatistic.setSize(new Dimension(300, 280));
        viewStatistic.setMinimumSize(new Dimension(300, 280));
        viewStatistic.setPreferredSize(new Dimension(300, 280));

        tabbedPane = new JTabbedPane();
        viewStatistic.add(tabbedPane);
    }

    public void openWindow(){
        tabbedPane.removeAll();
        viewStatistic.setVisible(true);
    }

    public void addTabPanel(Statistic statistic, int flag) {
        tabbedPane.addTab("Новичок", fillTab(statistic.getLists().get(0)));
        tabbedPane.addTab("Любитель", fillTab(statistic.getLists().get(1)));
        tabbedPane.addTab("Профессионал", fillTab(statistic.getLists().get(2)));
        tabbedPane.setSelectedIndex(flag);
    }

    public JPanel fillTab( List<StringRecord> recordList){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        int sequenceNumber = 1;
        for (StringRecord stringRecord : recordList) {
            String text = String.format(STATISTICS_RECORD_FORMAT, sequenceNumber, stringRecord.getTimeSec(), stringRecord.getName());
            sequenceNumber++;
            panel.add(new JLabel(text));
        }
        return panel;
    }
}

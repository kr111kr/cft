package view;

import controler.StatisticController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRecordWindow {


    private static final String STATISTICS_RECORD_FORMAT = "%s.  %-10s : %s";

    private JFrame newRecord;
    private JPanel panel;
    private JTextPane textWin;
    private JTextField textField;
    private JButton okButton;
    private JButton cancelButton;


    public AddRecordWindow(StatisticController statisticController, int time) throws HeadlessException {
        newRecord = new JFrame("Новый рекорд");
        newRecord.setSize(new Dimension(350, 170));
        newRecord.setMinimumSize(new Dimension(350, 170));
        newRecord.setPreferredSize(new Dimension(350, 170));
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        textWin = new JTextPane();
        textWin.setBackground(panel.getBackground());
        textWin.setEditable(false);
        textWin.setText(String.format("Поздравляю вы победили и вошли в таблицу рекордов\n с результатом %d, пожалуйста введите свое имя", time));

        panel.add(textWin);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(newRecord.getWidth() - 50, 30));
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(textField);

        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(90, 30));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Okay");
                statisticController.addNewName(textField.getText(), time);
                newRecord.dispose();
            }
        });

        cancelButton = new JButton("CANCEL");
        cancelButton.setPreferredSize(new Dimension(90, 30));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancel");

                newRecord.dispose();
            }
        });

        JPanel grid = new JPanel(new GridLayout(1, 2, 5, 8));
        grid.add(okButton);
        grid.add(cancelButton);

        panel.add(grid);

        newRecord.add(panel);

        newRecord.setResizable(false);
        newRecord.setVisible(true);
    }
}


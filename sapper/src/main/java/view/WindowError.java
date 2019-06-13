package view;

import javax.swing.*;
import java.awt.*;

public class WindowError {

    private JFrame viewError;

    public WindowError(String string){
        if (viewError != null){
            viewError.dispose();
        }
        viewError = new JFrame("Ошибка");
        viewError.setSize(new Dimension(300, 120));
        viewError.setMinimumSize(new Dimension(300, 100));
        viewError.setPreferredSize(new Dimension(300, 100));
        JPanel panelError = new JPanel();
        JLabel label = new JLabel(string);
        panelError.add(label);

        JButton okButton = new JButton("OK2");
        okButton.setPreferredSize(new Dimension(90, 30));
        okButton.addActionListener(e -> {
            viewError.dispose();
        });

        panelError.add(okButton);
        viewError.add(panelError);
        viewError.setResizable(false);
        viewError.setVisible(true);

    }





}

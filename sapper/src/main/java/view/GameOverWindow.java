package view;

import controler.Controller;

import javax.swing.*;
import java.awt.*;

public class GameOverWindow {
    private static final Dimension MIN_SIZE = new Dimension(10, 90);



    private JFrame viewForm;
    private FieldViewPanel fieldView;

    public GameOverWindow(Controller controller) {
        this.viewForm = new JFrame("Saper");
        viewForm.setMinimumSize(MIN_SIZE);
        // viewForm.setMaximumSize(new Dimension(10000, 3000));
        //viewForm.updateSize(START_SIZE);
        viewForm.setResizable(false);
        viewForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        viewForm.setJMenuBar(new MenuBar(controller));
        // viewForm.add(new MenuBar(), BorderLayout.NORTH);
        fieldView = new FieldViewPanel(controller);
        viewForm.add(fieldView, BorderLayout.CENTER);
       // viewForm.add(new ControlPanel(fieldView, this), BorderLayout.NORTH);
    }
}

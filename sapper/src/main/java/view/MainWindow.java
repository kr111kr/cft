package view;

import controler.Controller;

import javax.swing.*;
import java.awt.*;

public class MainWindow {

   // private static final Dimension START_SIZE = new Dimension(10 * 21 + 10, 10 * 21 + 10);
    private static final Dimension MIN_SIZE = new Dimension(10, 90);
   // private final int PANEL_SIZE = 800;
    private int CELL_SIZE = 30;

    private JFrame viewForm;
    private FieldViewPanel fieldView;
    private ControlPanel controlPanel;

    public MainWindow(Controller controller) {
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
        controlPanel = new ControlPanel(controller, fieldView, this);
        viewForm.add(controlPanel, BorderLayout.NORTH);
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public FieldViewPanel getFieldViewPanel() {
        return fieldView;
    }

    public void set(FieldViewPanel fieldViewPanel) {
        this.fieldView = fieldViewPanel;
    }

    public void updateSize() {
        viewForm.setSize(fieldView.getWidth(), fieldView.getHeight() + 60);
    }

    public void show() {
        viewForm.setVisible(true);
    }
}

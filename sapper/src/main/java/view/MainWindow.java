package view;

import controler.Controller;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainWindow {

    private static final Dimension MIN_SIZE = new Dimension(10, 90);

    private JFrame viewForm;
    private FieldViewPanel fieldView;
    private ControlPanel controlPanel;

    public MainWindow(Controller controller) {
        try {
            this.viewForm = new JFrame("MineSweeper");
            viewForm.setMinimumSize(MIN_SIZE);
            viewForm.setResizable(false);
            viewForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            viewForm.setJMenuBar(new MenuBar(controller));
            fieldView = new FieldViewPanel(controller);
            viewForm.add(fieldView, BorderLayout.CENTER);
            controlPanel = new ControlPanel(controller);
            viewForm.add(controlPanel, BorderLayout.NORTH);
        } catch (Exception e){
            viewForm.dispose();
            new WindowError("Не удалось загрузить изображения для игры");
        }

    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public FieldViewPanel getFieldViewPanel() {
        return fieldView;
    }

    public void updateSize() {
        viewForm.setSize(fieldView.getWidth(), fieldView.getHeight() + 60);
    }

    public void show() {
        viewForm.setVisible(true);
    }
}

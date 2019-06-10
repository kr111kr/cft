package view;

import controler.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ControlPanel extends JPanel {

    private static final int WIDTH = 100;
    private static final int COMPONENT_HEIGHT = 40;
    private static final Dimension MIN_SIZE = new Dimension(WIDTH, 30);
    private static final Dimension COMPONENT_SIZE = new Dimension(WIDTH, COMPONENT_HEIGHT);
    private Map<JComponent, Supplier<Boolean>> enabledSuppliers = new HashMap<>();
    private GridBagConstraints gbc = new GridBagConstraints();

    private TexturesPanel texturesPanel;
    private  JLabel glagBombCount;
    private JButton newGame;
    private TimerLabel timerLabel;

    private Controller controller;

    public ControlPanel(Controller controller, FieldViewPanel fieldViewPanel, MainWindow mainWindow) {
        this.controller = controller;

       // setUpLayout();
        setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.VERTICAL;
        setSize(MIN_SIZE);
        setMinimumSize(MIN_SIZE);
        setPreferredSize(MIN_SIZE);
        try {
            texturesPanel = new TexturesPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        //
        gbc.gridx = 0;
        glagBombCount = new JLabel();
        glagBombCount.setPreferredSize(new Dimension(27, 27));
        //glagBombCount.setText();
        glagBombCount.setPreferredSize(new Dimension(27, 27));
        glagBombCount.addMouseListener(new CustomListener());
        add(glagBombCount, gbc);


        gbc.gridx = 1;
        newGame = new JButton(texturesPanel.getNewGame());
        newGame.setPreferredSize(new Dimension(27, 27));
        newGame.addMouseListener(new CustomListener());
        add(newGame, gbc);
        gbc.gridx = 5;
        timerLabel = new TimerLabel();
        add(timerLabel, gbc);
    }

    public class CustomListener extends MouseAdapter {

        public CustomListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
           controller.newGame();
        }
    }

    public void updateFlagBomb(int bombOstatok){
        glagBombCount.setText(String.valueOf(bombOstatok));
    }

    public void setNewGame() {
        newGame.setIcon(texturesPanel.getNewGame());
       // remove(timerLabel);
        //timerLabel = new TimerLabel();
      //  add(timerLabel);
        timerLabel.cleanTimer();
    }

    public void startTimer(){
        timerLabel.startTimer();
    }

    public String setGameWins() {
        newGame.setIcon(texturesPanel.getGameWins());
        return timerLabel.stopTimer();
    }

    public String setGameLoss() {
        newGame.setIcon(texturesPanel.getGameLoss());
        return timerLabel.stopTimer();
    }

    private void setUpLayout() {
        setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.VERTICAL;
     //   gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 0;
       // gbc.anchor = GridBagConstraints.NORTHWEST;
    }

    /**
     * Добавляет растяжку в конце, которая заставляет все элементы собраться вверху панели
     */
   /* private void addFiller() {
        gbc.weighty = 1.0;
        add(new JPanel(), gbc);
        gbc = null;
    }*/

    /*private JButton addButton(String name, Runnable onClickAction, Supplier<Boolean> isEnabled) {
        JButton button = new JButton(name);
        button.setPreferredSize(COMPONENT_SIZE);
        button.addActionListener(e -> onClickAction.run());
        button.setEnabled(isEnabled.get());
        add(button, gbc);
        enabledSuppliers.put(button, isEnabled);
        gbc.gridx++;
        return button;
    }*/
/*
    private JLabel addLabel(String text) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(COMPONENT_SIZE);
        add(label, gbc);
        gbc.gridy++;
        return label;
    }

    private JTextField addTextField(String text, Supplier<Boolean> isEnabled) {
        JTextField textField = new JTextField(text);
        textField.setPreferredSize(COMPONENT_SIZE);
        add(textField, gbc);
        enabledSuppliers.put(textField, isEnabled);
        gbc.gridy++;
        return textField;
    }
*/
   /* private void updateComponents() {
        enabledSuppliers.keySet().forEach(key -> key.setEnabled(enabledSuppliers.get(key).get()));
    }*/
}

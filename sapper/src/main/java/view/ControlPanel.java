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
    private static final Dimension MIN_SIZE = new Dimension(WIDTH, 30);
    private GridBagConstraints gbc = new GridBagConstraints();

    private TexturesPanel texturesPanel;
    private JLabel glagBombCount;
    private JButton newGame;
    private TimerLabel timerLabel;

    private Controller controller;

    public ControlPanel(Controller controller) throws IOException {
        this.controller = controller;

        setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.VERTICAL;
        setSize(MIN_SIZE);
        setMinimumSize(MIN_SIZE);
        setPreferredSize(MIN_SIZE);

        texturesPanel = new TexturesPanel();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.1;
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.gridx = 0;
        glagBombCount = new JLabel();
        glagBombCount.setPreferredSize(new Dimension(27, 27));
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

    public void updateCountFlagBomb(int bombOstatok) {
        glagBombCount.setText(String.valueOf(bombOstatok));
    }

    public void setNewGame() {
        newGame.setIcon(texturesPanel.getNewGame());
        timerLabel.cleanTimer();
    }

    public void startTimer() {
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

    public class CustomListener extends MouseAdapter {

        public CustomListener() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            controller.newGame();
        }
    }
}

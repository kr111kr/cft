package view;

import controler.Controller;
import model.Cell;
import model.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.EventListener;
import java.util.List;

public class FieldViewPanel extends JPanel {

    private int CELL_SIZE = 30;

    private Textures textures;
    private MineButton[][] mineButtons;

    private Controller controller;

    private boolean gameOverFlag;

    public FieldViewPanel(Controller controller) {
        this.controller = controller;
        gameOverFlag = false;
        try {
            textures = new Textures();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void repaintCells(List<Cell> cells) {
        for (Cell cell : cells) {
            mineButtons[cell.getX()][cell.getY()].repaintCell();
        }
    }

    public void createEmptyField(Field field) {

        int rows = field.getGameConfiguration().getWidth();
        int columns = field.getGameConfiguration().getHeight();
        gameOverFlag = false;

        removeAll();

        setLayout(new GridLayout(rows, columns, 1, 1));
        setMinimumSize(new Dimension(field.getGameConfiguration().getWidth() * CELL_SIZE, field.getGameConfiguration().getHeight() * CELL_SIZE));
        setSize(new Dimension(field.getGameConfiguration().getHeight() * CELL_SIZE, field.getGameConfiguration().getWidth() * CELL_SIZE));
        setPreferredSize(new Dimension(field.getGameConfiguration().getWidth() * CELL_SIZE, field.getGameConfiguration().getHeight() * CELL_SIZE));

        mineButtons = new MineButton[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                mineButtons[i][j] = new MineButton(field.getField()[i][j], textures);
                mineButtons[i][j].setMinimumSize(new Dimension(CELL_SIZE, CELL_SIZE));
                mineButtons[i][j].setSize(new Dimension(CELL_SIZE, CELL_SIZE));
                mineButtons[i][j].setMaximumSize(new Dimension(CELL_SIZE, CELL_SIZE));
                mineButtons[i][j].addMouseListener(new CustomListener(field.getField()[i][j]));
                add(mineButtons[i][j]);
            }
        }
        revalidate();
    }

    public class CustomListener extends CustomOnMouseClickListener {
        private Cell cell;

        public CustomListener(Cell cell) {
            this.cell = cell;
        }

        @Override
        public void onLeftButton() {
            if (!gameOverFlag)
                controller.openCell(cell.getX(), cell.getY());
        }

        @Override
        public void onRightButton() {
            if (!gameOverFlag)
                controller.switchFlag(cell.getX(), cell.getY());
        }

        @Override
        public void onDoubleLeftButton() {
            controller.openNonMarkedNeighbors(cell.getX(), cell.getY());
        }
    }
}

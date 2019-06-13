package view;

import controler.Controller;
import model.Cell;
import model.Field;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class FieldViewPanel extends JPanel {

    private int CELL_SIZE = 30;

    private TexturesCells texturesCells;
    private MineButton[][] mineButtons;

    private Controller controller;

    private boolean gameOverFlag;

    public FieldViewPanel(Controller controller) throws IOException {
        this.controller = controller;
        gameOverFlag = false;

        texturesCells = new TexturesCells();
    }

    public void repaintCells(List<Cell> cells) {
        for (Cell cell : cells) {
            mineButtons[cell.getX()][cell.getY()].repaintCell();
        }
    }

    public void setGameOver() {
        gameOverFlag = true;
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
                mineButtons[i][j] = new MineButton(field.getField()[i][j], texturesCells);
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
                controller.switchFlagCell(cell.getX(), cell.getY());
        }

        @Override
        public void onDoubleLeftButton() {
            controller.openNonMarkedNeighbors(cell.getX(), cell.getY());
        }
    }
}

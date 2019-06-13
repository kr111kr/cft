package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FieldLogic {

    public List<Cell> openCell(Field field, int x, int y) {

        if (field.getField()[x][y].getIsFlag() != 0) {
            return new ArrayList<>();
        }
        if (field.getField()[x][y].isOpen()) {
            return new ArrayList<>();
        }

        List<Cell> openedCells = new ArrayList<>();
        openedCells.add(field.getField()[x][y]);

        if (field.getField()[x][y].isBomb()) {
            for (int i = 0; i < field.getGameConfiguration().getWidth(); ++i) {
                for (int j = 0; j < field.getGameConfiguration().getHeight(); ++j) {
                    if (field.getField()[i][j].isBomb()) {
                        field.getField()[i][j].setOpen(true);
                        openedCells.add(field.getField()[i][j]);
                    }
                }
            }
            field.setBombOpen(true);
            field.getField()[x][y].setFirstOpenBomb(true);
            int countOpenCell = field.getGameConfiguration().getWidth() * field.getGameConfiguration().getHeight();
            field.setCountOpenCell(countOpenCell + openedCells.size());
            return openedCells;
        }

        int pointer = 0;

        while (pointer < openedCells.size()) {
            Cell cell = openedCells.get(pointer);
            if (cell.getCountBomb() > 0) {
                pointer++;
                continue;
            } else {
                for (int offsetX = -1; offsetX <= 1; offsetX++) {
                    for (int offsetY = -1; offsetY <= 1; offsetY++) {
                        int neighbourX = offsetX + cell.getX();
                        int neighbourY = offsetY + cell.getY();
                        if (!outBounds(field, neighbourX, neighbourY) && (offsetX != 0 || offsetY != 0)
                                && !openedCells.contains(field.getField()[neighbourX][neighbourY])
                                && !field.getField()[neighbourX][neighbourY].isOpen()
                                && field.getField()[neighbourX][neighbourY].getIsFlag() == 0) {
                            openedCells.add(field.getField()[neighbourX][neighbourY]);
                        }
                    }
                }
            }

            pointer++;
        }

        for (Cell cell : openedCells) {
            cell.setOpen(true);
        }

        int countOpenCell = field.getCountOpenCell();
        field.setCountOpenCell(countOpenCell + openedCells.size());
        return openedCells;
    }

    public List<Cell> openCellCircle(Field field, int x, int y) {
        List<Cell> cellsOpened = new ArrayList<>();

        if (field.getField()[x][y].isOpen()) {

            List<Cell> cellsRequiringRepaint = new ArrayList<>();

            int countFlag = 0;
            for (int offsetX = -1; offsetX <= 1; offsetX++) {
                for (int offsetY = -1; offsetY <= 1; offsetY++) {
                    int neighbourX = offsetX + x;
                    int neighbourY = offsetY + y;
                    if (!outBounds(field, neighbourX, neighbourY) && (offsetX != 0 || offsetY != 0)) {
                        if (field.getField()[neighbourX][neighbourY].getIsFlag() == 1) {
                            countFlag++;
                        } else {
                            cellsRequiringRepaint.add(field.getField()[neighbourX][neighbourY]);
                        }
                    }
                }
            }

            if (countFlag == field.getField()[x][y].getCountBomb()) {
                for (Cell cell : cellsRequiringRepaint) {
                    cellsOpened.addAll(openCell(field, cell.getX(), cell.getY()));
                }
            }
        }
        return cellsOpened;
    }

    private boolean outBounds(Field field, int x, int y) {
        return x < 0 || y < 0 || x >= field.getGameConfiguration().getWidth() || y >= field.getGameConfiguration().getHeight();
    }

    public boolean gameOver(Field field) {
        for (int i = 0; i < field.getGameConfiguration().getWidth(); ++i) {
            for (int j = 0; j < field.getGameConfiguration().getHeight(); ++j) {
                field.getField()[i][j].isOpen();
            }
        }

        if (field.getCountOpenCell() >= (field.getGameConfiguration().getHeight() * field.getGameConfiguration().getWidth() - field.getGameConfiguration().getCountBomb())) {
            return true;
        }
        return false;
    }

    public List<Cell> changeFlag(Field field, int x, int y) {
        if (!field.getField()[x][y].isOpen()) {
            field.getField()[x][y].setIsFlag((field.getField()[x][y].getIsFlag() + 1) % 3);//ООченььььь ПЛООООХХОООО
            if (field.getField()[x][y].getIsFlag() == 1) {
                field.setCountFlagCell(field.getCountFlagCell() + 1);
            } else if (field.getField()[x][y].getIsFlag() == 0) {
                field.setCountFlagCell(field.getCountFlagCell() - 1);
            }
            return (Collections.singletonList(field.getField()[x][y]));
        }
        return new ArrayList<>();
    }
}

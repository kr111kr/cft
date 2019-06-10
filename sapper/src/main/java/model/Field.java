package model;

import java.util.ArrayList;
import java.util.List;

public class Field {
    //private List<List<Integer>> field = new ArrayLi ArrayList<Integer>[10][10];

    private Cell[][] field;
    private GameConfiguration gameConfiguration;
   /* private int height;
    private int width;
    private int countMine;*/
    private int countOpenCell;
    private int countFlagCell;
    private boolean isBombOpen;

   /* public int getCountMine() {
        return gameConfiguration.getCountBomb();
    }

    public void setCountMine(int countMine) {
        this.gameConfiguration.setCountBomb(countMine);
    }*/

    public boolean isBombOpen() {
        return isBombOpen;
    }

    public void setBombOpen(boolean bombOpen) {
        isBombOpen = bombOpen;
    }

    public int getCountOpenCell() {
        return countOpenCell;
    }

    public void setCountOpenCell(int countOpenCell) {
        this.countOpenCell = countOpenCell;
    }

    public int getCountFlagCell() {
        return countFlagCell;
    }

    public void setCountFlagCell(int countFlagCell) {
        this.countFlagCell = countFlagCell;
    }

    public Field(GameConfiguration gameConfiguration){//int width, int height) {
        this.gameConfiguration = gameConfiguration;
        this.field = new Cell[gameConfiguration.getWidth()][gameConfiguration.getHeight()];
    }

 /*   public int getHeight() {
        return gameConfiguration.getHeight();
    }

    public void setHeight(int height) {
        this.gameConfiguration.setHeight(height);
    }

    public int getWidth() {
        return gameConfiguration.getWidth();
    }

    public void setWidth(int width) {
        this.gameConfiguration.setWidth(width);
    }*/

    public Cell[][] getField() {
        return field;
    }

    public void setField(Cell[][] field) {
        this.field = field;
    }

    public GameConfiguration getGameConfiguration() {
        return gameConfiguration;
    }

    public void setGameConfiguration(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
    }
}

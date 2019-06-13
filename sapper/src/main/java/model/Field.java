package model;

public class Field {
    private Cell[][] field;
    private GameConfiguration gameConfiguration;
    private boolean isBombOpen;
    private int countOpenCell;
    private int countFlagCell;

    public Field(GameConfiguration gameConfiguration) {
        this.gameConfiguration = gameConfiguration;
        this.field = new Cell[gameConfiguration.getWidth()][gameConfiguration.getHeight()];
    }

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

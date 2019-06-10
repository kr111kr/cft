package model;

public class Cell {
    private int x;
    private int y;
    private boolean isOpen;
    private boolean isBomb;
    private int isFlag;
    private  boolean isFirstOpenBomb;
    private int countBomb;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(int isFlag) {
        this.isFlag = isFlag;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public int getCountBomb() {
        return countBomb;
    }

    public void setCountBomb(int countBomb) {
        this.countBomb = countBomb;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isFirstOpenBomb() {
        return isFirstOpenBomb;
    }

    public void setFirstOpenBomb(boolean firstOpenBomb) {
        isFirstOpenBomb = firstOpenBomb;
    }
}

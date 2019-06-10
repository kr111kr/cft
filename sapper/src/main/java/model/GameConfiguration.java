package model;

public class GameConfiguration {
    private String name;
    private int height;
    private int width;
    private int countBomb;
    private boolean fixRecord;
    private int numberSpiskaRecord;

    public GameConfiguration(String name, int height, int width, int countBomb, boolean fixRecord) {
        this(name, height, width, countBomb, false, -1);
    }

    public GameConfiguration(String name, int height, int width, int countBomb, boolean fixRecord, int numberSpiskaRecord) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.countBomb = countBomb;
        this.fixRecord = fixRecord;
        this.numberSpiskaRecord = numberSpiskaRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getCountBomb() {
        return countBomb;
    }

    public void setCountBomb(int countBomb) {
        this.countBomb = countBomb;
    }

    public boolean isFixRecord() {
        return fixRecord;
    }

    public void setFixRecord(boolean fixRecord) {
        this.fixRecord = fixRecord;
    }

    public int getNumberSpiskaRecord() {
        return numberSpiskaRecord;
    }

    public void setNumberSpiskaRecord(int numberSpiskaRecord) {
        this.numberSpiskaRecord = numberSpiskaRecord;
    }
}

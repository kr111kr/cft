package model;

public class GameConfiguration {
    private String name;
    private int height;
    private int width;
    private int countBomb;
    private boolean fixRecord;
    private int numberListRecord;

    public GameConfiguration(String name, int height, int width, int countBomb) {
        this(name, height, width, countBomb, false, -1);
    }

    public GameConfiguration(String name, int height, int width, int countBomb, boolean fixRecord, int numberListRecord) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.countBomb = countBomb;
        this.fixRecord = fixRecord;
        this.numberListRecord = numberListRecord;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getCountBomb() {
        return countBomb;
    }

    public boolean isFixRecord() {
        return fixRecord;
    }

    public int getNumberListRecord() {
        return numberListRecord;
    }
}

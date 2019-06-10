package model;

public class StringRecord implements Comparable<StringRecord> {
    private String name;
    private int timeSec;

    public StringRecord(String name, int timeSec) {
        this.name = name;
        this.timeSec = timeSec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeSec() {
        return timeSec;
    }

    public void setTimeSec(int timeSec) {
        this.timeSec = timeSec;
    }

    @Override
    public int compareTo(StringRecord o) {
        if (this.timeSec > ((StringRecord) o).timeSec) {
            return 1;
        } else if (this.timeSec == ((StringRecord) o).timeSec) {
            return 0;
        } else {
            return -1;
        }

        //return 0;
    }
}

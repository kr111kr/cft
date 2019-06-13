package model;

import java.util.ArrayList;
import java.util.List;

public class Statistic {

    private List<List<StringRecord>> lists;
    private List<String> paths;

    public Statistic() {
        lists = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            lists.add(new ArrayList<>());
        }

        paths = new ArrayList<>();
        paths.add("./src/main/resources/statistic/starter.txt");
        paths.add("./src/main/resources/statistic/normal.txt");
        paths.add("./src/main/resources/statistic/profi.txt");
    }

    public List<List<StringRecord>> getLists() {
        return lists;
    }

    public List<String> getPaths() {
        return paths;
    }
}

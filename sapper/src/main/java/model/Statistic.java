package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class Statistic {

   /* private List<StringRecord> starterRecords;
    private List<StringRecord> normalRecords;
    private List<StringRecord> profiRecords;

*/
    private List<StringRecord> starterRecords;
    private List<StringRecord> normalRecords;
    private List<StringRecord> profiRecords;


    private List<List<StringRecord>> lists;
    private List<String> puths;


    private String puthStarter;
    private String puthNormal;
    private String puthProfi;

    public Statistic() {
        //starterRecords = new ArrayList<>();
        lists = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            lists.add(new ArrayList<>());
        }

        puths = new ArrayList<>();
        puths.add("./src/main/resources/statistic/starter.txt");
        puths.add("./src/main/resources/statistic/normal.txt");
        puths.add("./src/main/resources/statistic/profi.txt");
        ////lists[0].add(new StringRecord());
    }

    public List<List<StringRecord>> getLists() {
        return lists;
    }

    public void setLists(List<List<StringRecord>> lists) {
        this.lists = lists;
    }

    public List<String> getPuths() {
        return puths;
    }

    public void setPuths(List<String> puths) {
        this.puths = puths;
    }

    public void getString(){
        try {
            FileReader fileReader = ScannerString.openFileReader("");
            List<String> starter = ScannerString.scannerFile(fileReader);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){

        }
    }


}

package model;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.List;

public class StatisticLogic {

    public void fillString(Statistic statistic) {
        try {

            for (int i = 0; i < 3; ++i) {
                FileReader fileReader = ScannerString.openFileReader(statistic.getPuths().get(i));
                List<String> starter = ScannerString.scannerFile(fileReader);
                statistic.getLists().get(i).clear();
                statistic.getLists().get(i).addAll(parseString(starter));
                Comparator<StringRecord> comparator = Comparator.comparing(obj -> obj.getTimeSec());
                statistic.getLists().get(i).sort(comparator);

                fileReader.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }
    }

    public void addString(Statistic statistic, int indexPuths, StringRecord stringRecord) {

        statistic.getLists().get(indexPuths).add(stringRecord);
        Comparator<StringRecord> comparator = Comparator.comparing(obj -> obj.getTimeSec());
        statistic.getLists().get(indexPuths).sort(comparator);
        if (statistic.getLists().get(indexPuths).size() > 10) {
            statistic.getLists().get(indexPuths).remove(10);
        }

    }

    public void updateFile(Statistic statistic, int indexPuths) {

        try {
            //File file = new File(statistic.getPuths().get(indexPuths));
            //file.
            FileWriter fileWriter = new FileWriter(statistic.getPuths().get(indexPuths));

            for (StringRecord stringRecord : statistic.getLists().get(indexPuths)) {
                fileWriter.write(stringRecord.getName() + " " + stringRecord.getTimeSec() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<StringRecord> parseString(List<String> strings) {
        List<StringRecord> recordList = new ArrayList<>();

        for (String stri : strings) {
            String[] as = stri.split(" ");

            try {
                if (as.length == 2) {
                    //StringRecord stringRecord = new StringRecord();
                    // stringRecord.setName(as[0]);
                    Integer valueInput = Integer.parseInt(as[1].replace(",", "."));
                    //stringRecord.setTimeSec(valueInput);
                    StringRecord stringRecord = new StringRecord(as[0], valueInput);
                    recordList.add(stringRecord);
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Неверный формат данных");
            }

        }

        return recordList;

    }

    public boolean checkNewTime(Statistic statistic, int time, int flagSizeField) {
        List<StringRecord> queneStringRecord = statistic.getLists().get(flagSizeField);
        if (queneStringRecord.size() < 10) {
            return true;
        }

        for (StringRecord stringRecord : queneStringRecord) {//.element().add()
            if (stringRecord.getTimeSec() > time) {
                return true;
            }
        }
        return false;
    }
}

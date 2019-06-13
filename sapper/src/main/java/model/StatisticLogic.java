package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StatisticLogic {

    static final private int COUNT_FIX_RECORD = 10;

    public void fillString(Statistic statistic) throws IOException {

        for (int i = 0; i < 3; ++i) {
            FileReader fileReader = ScannerString.openFileReader(statistic.getPaths().get(i));
            List<String> starter = ScannerString.scannerFile(fileReader);
            statistic.getLists().get(i).clear();
            statistic.getLists().get(i).addAll(parseString(starter));
            Comparator<StringRecord> comparator = Comparator.comparing(obj -> obj.getTimeSec());
            statistic.getLists().get(i).sort(comparator);

            fileReader.close();
        }
    }

    public void addString(Statistic statistic, int indexPaths, StringRecord stringRecord) {

        statistic.getLists().get(indexPaths).add(stringRecord);
        Comparator<StringRecord> comparator = Comparator.comparing(obj -> obj.getTimeSec());
        statistic.getLists().get(indexPaths).sort(comparator);
        if (statistic.getLists().get(indexPaths).size() > COUNT_FIX_RECORD) {
            statistic.getLists().get(indexPaths).remove(COUNT_FIX_RECORD);
        }
    }

    public void updateFile(Statistic statistic, int indexPaths) throws IOException {

        FileWriter fileWriter = new FileWriter(statistic.getPaths().get(indexPaths));

        for (StringRecord stringRecord : statistic.getLists().get(indexPaths)) {
            fileWriter.write(stringRecord.getName() + " " + stringRecord.getTimeSec() + System.lineSeparator());
        }
        fileWriter.close();
    }

    public List<StringRecord> parseString(List<String> startStrings) {
        List<StringRecord> recordList = new ArrayList<>();

        for (String string : startStrings) {
            String[] stringToSpace = string.split(" ");
            if (stringToSpace.length == 2) {
                Integer valueInput = Integer.parseInt(stringToSpace[1].replace(",", "."));
                StringRecord stringRecord = new StringRecord(stringToSpace[0], valueInput);
                recordList.add(stringRecord);
            }
        }

        return recordList;
    }

    public boolean checkNewTime(Statistic statistic, int time, int flagSizeField) {
        List<StringRecord> queueStringRecord = statistic.getLists().get(flagSizeField);
        if (queueStringRecord.size() < COUNT_FIX_RECORD) {
            return true;
        }

        for (StringRecord stringRecord : queueStringRecord) {
            if (stringRecord.getTimeSec() > time) {
                return true;
            }
        }
        return false;
    }
}

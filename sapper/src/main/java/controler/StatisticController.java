package controler;

import model.Statistic;
import model.StatisticLogic;
import model.StringRecord;
import view.AddRecordWindow;
import view.StatisticWindow;
import view.WindowError;

import java.io.IOException;

public class StatisticController {
    private Statistic statistic;
    private StatisticLogic statisticLogic;
    private int flagSizeField;
    private StatisticWindow statisticWindow;


    public StatisticController() {
        this.statistic = new Statistic();
        this.statisticLogic = new StatisticLogic();
        this.statisticWindow = new StatisticWindow();
    }

    public void fill() throws IOException {
        statisticLogic.fillString(statistic);
    }

    public void openWindow(int flagSizeField) throws IOException {
        fill();
        statisticWindow.openWindow();
        statisticWindow.addTabPanel(statistic, flagSizeField);
    }

    public void addNewName(String name, int time) {
        try {
            if (name != null) {
                statisticLogic.addString(statistic, flagSizeField, new StringRecord(name, time));
                statisticLogic.updateFile(statistic, flagSizeField);
                openWindow(flagSizeField);
            }
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл с рекордами, открывать окно с ними бессмысленно");
            errorWindowView(e);
        }
    }

    public void errorWindowView(IOException e) {
        new WindowError("Не удалось получить файл с рекордами");
    }

    public void checkTime(int time, int flagSizeField) {
        try {
            this.flagSizeField = flagSizeField;
            fill();
            boolean newTime = statisticLogic.checkNewTime(statistic, time, flagSizeField);
            if (newTime) {
                AddRecordWindow addRecordWindow = new AddRecordWindow(this, time);
            }
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл с рекордами, открывать окно с ними бессмысленно");
            errorWindowView(e);
        }
    }

}

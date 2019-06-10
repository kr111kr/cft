package controler;

import model.Statistic;
import model.StatisticLogic;
import model.StringRecord;
import view.AddRecordWindow;
import view.StatisticWindow;

public class StatisticController {
    private Statistic statistic;;// = new Statistic();
    private StatisticLogic statisticLogic;// = new StatisticLogic();
    private StatisticWindow statisticWindow;// = new StatisticWindow();
    private  int flagSizeField;

    public StatisticController() {
        this.statistic = new Statistic();
        this.statisticLogic = new StatisticLogic();
      //  this.statisticWindow = new StatisticWindow();
    }

    public void createWindow(){
       // statisticWindow = new StatisticWindow();
    }


    public void fill(){
        statisticLogic.fillString(statistic);
       // statisticWindow.addTabPanel(statistic);
        System.out.println("123");
    }

    public void openWindow(int flagSizeField){
        fill();
        this.statisticWindow = new StatisticWindow();
        statisticWindow.addTabPanel(statistic, flagSizeField);
    }

    public void addNewName(String name, int time){
        if (name != null){
            statisticLogic.addString(statistic,flagSizeField,new StringRecord(name, time));
            statisticLogic.updateFile(statistic, flagSizeField);
            openWindow(flagSizeField);
        }
    }

    public void checkTime(int time, int flagSizeField){
        this.flagSizeField = flagSizeField;
        boolean newTime = statisticLogic.checkNewTime(statistic, time, flagSizeField);
        if (newTime){
            AddRecordWindow addRecordWindow = new AddRecordWindow(this, time);
        }
    }

}

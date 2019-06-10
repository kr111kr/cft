package controler;

import model.*;
import view.FieldViewPanel;
import view.MainWindow;
import view.SpecialSettings;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Controller {

   // public final

    private Field field;
    private FieldGenerator fieldGenerator = new FieldGenerator();
    private FieldLogic fieldLogic = new FieldLogic();
    private DefaultConfiguration defaultConfiguration = new DefaultConfiguration();

    private FieldViewPanel fieldViewPanel;
    private MainWindow mainWindow;

    private StatisticController statisticController = new StatisticController();

    private boolean isFirstClick;

    public StatisticController getStatisticController() {
        return statisticController;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.fieldViewPanel = mainWindow.getFieldViewPanel();
    }

    public void setFieldViewPanel(FieldViewPanel fieldViewPanel) {
        this.fieldViewPanel = fieldViewPanel;
    }

    public void initialize()
    {
        newGame(defaultConfiguration.getGameConfigurations().get(0));
    }

    public void newGame(){
        newGame(field.getGameConfiguration());
    }

    public void newGame(GameConfiguration gameConfiguration){//int w, int h, int mine){
        isFirstClick = true;
        field = fieldGenerator.createField(gameConfiguration);
        //field.setCountMine(mine);
        fieldViewPanel.createEmptyField(field);

        field.setCountOpenCell(0);
        field.setCountFlagCell(0);
        mainWindow.updateSize();

        mainWindow.getControlPanel().setNewGame();
        mainWindow.getControlPanel().updateFlagBomb(field.getGameConfiguration().getCountBomb());


        statisticController.fill();

    }

    public void openCell(int x, int y){
        if (isFirstClick)
        {
            fieldGenerator.generateMine(field, x, y);
           // field.setCountOpenCell(0);
           // field.setCountFlagCell(0);
            isFirstClick = false;
            mainWindow.getControlPanel().startTimer();

        }
        List<Cell> updateCells = fieldLogic.openCell(field, x, y);
        fieldViewPanel.repaintCells(updateCells);
        checkGameOver();
    }

    public void openNonMarkedNeighbors(int x, int y){
        List<Cell> updateCells = fieldLogic.openCellCircle(field, x, y);
        fieldViewPanel.repaintCells(updateCells);
        checkGameOver();
    }

    public void switchFlag(int x, int y){
        List<Cell> updateCells = fieldLogic.changeFlag(field, x, y);
        fieldViewPanel.repaintCells(updateCells);
        mainWindow.getControlPanel().updateFlagBomb(field.getGameConfiguration().getCountBomb() - field.getCountFlagCell());
    }

    private void checkGameOver()
    {
        if (fieldLogic.gameOver(field))
        {
            String stopTime;
            if (field.isBombOpen()) {
               stopTime =  mainWindow.getControlPanel().setGameLoss();

            }
            else {
                stopTime = mainWindow.getControlPanel().setGameWins();

                if (field.getGameConfiguration().isFixRecord()) {//getHeight() == 9 && field.getWidth() == 9 && field.getCountMine() == 10)
                    statisticController.checkTime(Integer.parseInt(stopTime), field.getGameConfiguration().getNumberSpiskaRecord());
                }
            }
        }
    }

    public DefaultConfiguration getDefaultConfiguration() {
        return defaultConfiguration;
    }

    public void getOpenSpecialSettings(){
        new SpecialSettings(this);
    }
}

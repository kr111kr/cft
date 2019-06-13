package controler;

import model.*;
import view.FieldViewPanel;
import view.MainWindow;
import view.SpecialSettings;

import java.util.List;

public class Controller {
    private Field field;
    private FieldGenerator fieldGenerator;
    private FieldLogic fieldLogic;
    private DefaultConfiguration defaultConfigurationField;

    private FieldViewPanel fieldViewPanel;
    private MainWindow mainWindow;

    private StatisticController statisticController;

    private boolean isFirstClick;

    public StatisticController getStatisticController() {
        return statisticController;
    }

    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.fieldViewPanel = mainWindow.getFieldViewPanel();
    }

    public void initialize() {
        defaultConfigurationField = new DefaultConfiguration();
        newGame(defaultConfigurationField.getGameConfigurations().get(0));
    }

    public void newGame() {
        newGame(field.getGameConfiguration());
    }

    public void newGame(GameConfiguration gameConfiguration) {
        isFirstClick = true;
        fieldGenerator = new FieldGenerator();
        fieldLogic = new FieldLogic();

        field = fieldGenerator.createField(gameConfiguration);
        fieldViewPanel.createEmptyField(field);

        field.setCountOpenCell(0);
        field.setCountFlagCell(0);
        mainWindow.updateSize();

        mainWindow.getControlPanel().setNewGame();
        mainWindow.getControlPanel().updateCountFlagBomb(field.getGameConfiguration().getCountBomb());

        statisticController = new StatisticController();
        // statisticController.fill();

    }

    public void openCell(int x, int y) {
        if (isFirstClick) {
            fieldGenerator.generateMine(field, x, y);
            isFirstClick = false;
            mainWindow.getControlPanel().startTimer();
        }

        List<Cell> updateCells = fieldLogic.openCell(field, x, y);
        fieldViewPanel.repaintCells(updateCells);
        checkGameOver();
    }

    public void openNonMarkedNeighbors(int x, int y) {
        List<Cell> updateCells = fieldLogic.openCellCircle(field, x, y);
        fieldViewPanel.repaintCells(updateCells);
        checkGameOver();
    }

    public void switchFlagCell(int x, int y) {
        List<Cell> updateCells = fieldLogic.changeFlag(field, x, y);
        fieldViewPanel.repaintCells(updateCells);
        mainWindow.getControlPanel().updateCountFlagBomb(field.getGameConfiguration().getCountBomb() - field.getCountFlagCell());
    }

    private void checkGameOver() {
        if (fieldLogic.gameOver(field)) {
            fieldViewPanel.setGameOver();
            if (field.isBombOpen()) {
                mainWindow.getControlPanel().setGameLoss();

            } else {
                String stopTime = mainWindow.getControlPanel().setGameWins();

                if (field.getGameConfiguration().isFixRecord()) {
                    statisticController.checkTime(Integer.parseInt(stopTime), field.getGameConfiguration().getNumberListRecord());
                }
            }
        }
    }

    public DefaultConfiguration getDefaultConfigurationField() {
        if (defaultConfigurationField == null) {
            defaultConfigurationField = new DefaultConfiguration();
        }
        return defaultConfigurationField;
    }

    public void getOpenSpecialSettings() {
        new SpecialSettings(this);
    }
}

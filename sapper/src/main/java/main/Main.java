package main;

import controler.Controller;
import view.MainWindow;

public class Main {
    public static void main(String args[]) {
        Controller controller = new Controller();

        MainWindow mainWindow = new MainWindow(controller);

        controller.setMainWindow(mainWindow);
        controller.initialize();
        mainWindow.show();
    }
}

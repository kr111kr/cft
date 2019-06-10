package main;

import controler.Controller;
import view.MainWindow;

public class Main {
    public static void main(String args[]) {
       /* FieldGenerator generateField = new FieldGenerator();
        generateField.createField(10, 10);
        Frame frame = new Frame();
        frame.initComponents();

*/

        Controller controller = new Controller();

        MainWindow jf = new MainWindow(controller);
        controller.setMainWindow(jf);
        //controller.setFieldViewPanel(jf.getFieldViewPanel());

        controller.initialize();
        jf.show();

    }

}

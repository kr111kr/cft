package ru.nsu.popova;

import ru.nsu.popova.model.Factory.FactoryFigure;
import ru.nsu.popova.model.figure.Figure;
import ru.nsu.popova.model.scanner.ScannerString;
import ru.nsu.popova.view.factory.FactoryPrint;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        try {
            FileReader fr = ScannerString.openFileReader();
            List<String> line = ScannerString.scannerFile(fr);
            String nameFigure = line.get(0);

            FactoryFigure factoryFigure = new FactoryFigure();
            factoryFigure.initialize();
            Figure figure = factoryFigure.build(nameFigure, line.get(1));

            FactoryPrint factoryPrint = new FactoryPrint();
            factoryPrint.initialize();
            factoryPrint.print(nameFigure, figure);
        }
        catch (Exception e)
        {
            System.out.println( e.getMessage());
        }
    }
}

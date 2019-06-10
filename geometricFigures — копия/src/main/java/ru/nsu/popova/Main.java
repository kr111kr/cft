package ru.nsu.popova;

import ru.nsu.popova.model.Factory.FactoryFigure;
import ru.nsu.popova.model.figure.Circle;
import ru.nsu.popova.model.figure.Figure;
import ru.nsu.popova.model.figure.Rectangle;
import ru.nsu.popova.model.figure.Triangle;
import ru.nsu.popova.model.scanner.ScannerString;
import ru.nsu.popova.view.ViewParametrs;
import ru.nsu.popova.view.factory.FactoryPrint;

import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        System.out.println("5454");
       // Scanner scan = new Scanner(System.in);
        String s =  "";
      /*  if (scan.hasNext())
        {
            s = scan.nextLine().toUpperCase();
        }*/

        s = ScannerString.scannerOneString();// scanner = new ScannerString();

        FactoryFigure factoryFigure = new FactoryFigure();
        factoryFigure.initialize();
        Figure figure = factoryFigure.build(s, ScannerString.scannerString());

        FactoryPrint factoryPrint = new FactoryPrint();
        factoryPrint.initialize();
        factoryPrint.print(s, figure);
        /*
        FigureType figureType = Enum.valueOf(FigureType.class, s);

        Figure figure = new Figure("vv");

        switch (figureType)
        {
            case CIRCLE:
                figure = new Circle();
                System.out.println(FigureType.CIRCLE);
                break;
            case TRIANGLE:
                figure = new Triangle();
                System.out.println(FigureType.TRIANGLE);
                break;
            case RECTANGLE:
                figure = new Rectangle();
                System.out.println(FigureType.RECTANGLE);
                break;

        }

        figure.readInput();
        ViewParametrs viewParametrs = new ViewParametrs();
        viewParametrs.printData(figure.getName(), figure.getParametr());*/
    }

    enum FigureType {
        CIRCLE,
        TRIANGLE,
        RECTANGLE
    }
}

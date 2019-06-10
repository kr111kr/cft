package ru.nsu.popova.view.factory;

import ru.nsu.popova.model.figure.Figure;
import ru.nsu.popova.view.print.PrintCircle;
import ru.nsu.popova.view.print.PrintFigure;
import ru.nsu.popova.view.print.PrintRectangle;
import ru.nsu.popova.view.print.PrintTriangle;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FactoryPrint {
    private Map<String, PrintFigure<Figure>> builder = new HashMap<>();

    public void initialize() {
        builder.put("CIRCLE", new PrintCircle());
        builder.put("TRIANGLE", new PrintTriangle());
        builder.put("RECTANGLE", new PrintRectangle());
    }

    public void print(String name, Figure figure) throws IOException {
        builder.get(name).print(figure);
    }

}

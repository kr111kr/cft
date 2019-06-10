package ru.nsu.popova.view.factory;

import ru.nsu.popova.model.builderFigure.BuilderCircle;
import ru.nsu.popova.model.builderFigure.BuilderFigure;
import ru.nsu.popova.model.builderFigure.BuilderRectangle;
import ru.nsu.popova.model.builderFigure.BuilderTriangle;
import ru.nsu.popova.model.figure.Figure;
import ru.nsu.popova.view.print.PrintCircle;
import ru.nsu.popova.view.print.PrintFigure;
import ru.nsu.popova.view.print.PrintRectangle;
import ru.nsu.popova.view.print.PrintTriangle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FactoryPrint {
    Map<String, PrintFigure<?>> builder = new HashMap<>();

    public void initialize(){
        builder.put("CIRCLE", new PrintCircle());
        builder.put("TRIANGLE", new PrintTriangle());
        builder.put("RECTANGLE", new PrintRectangle());
        /* builder.put("TRIANGLE", new BuilderTriangle());
        builder.put("RECTANGLE", new BuilderRectangle());*/
    }

    public void print(String name, Figure figure) {
         builder.get(name).print(figure);
    }

}

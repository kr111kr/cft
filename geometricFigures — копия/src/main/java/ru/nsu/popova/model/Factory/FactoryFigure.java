package ru.nsu.popova.model.Factory;

import ru.nsu.popova.model.builderFigure.BuilderCircle;
import ru.nsu.popova.model.builderFigure.BuilderFigure;
import ru.nsu.popova.model.builderFigure.BuilderRectangle;
import ru.nsu.popova.model.builderFigure.BuilderTriangle;
import ru.nsu.popova.model.figure.Figure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FactoryFigure {

    Map<String, BuilderFigure<?>> builder = new HashMap<>();

    public void initialize(){
        builder.put("CIRCLE", new BuilderCircle());
        builder.put("TRIANGLE", new BuilderTriangle());
        builder.put("RECTANGLE", new BuilderRectangle());
    }

    public Figure build(String name, ArrayList<String> parameterFigure) {
        return builder.get(name).build(parameterFigure);
    }
}

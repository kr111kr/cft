package ru.nsu.popova.model.Factory;

import ru.nsu.popova.model.builderFigure.BuilderCircle;
import ru.nsu.popova.model.builderFigure.BuilderFigure;
import ru.nsu.popova.model.builderFigure.BuilderRectangle;
import ru.nsu.popova.model.builderFigure.BuilderTriangle;
import ru.nsu.popova.model.figure.Figure;

import java.util.HashMap;
import java.util.Map;

public class FactoryFigure {

    private Map<String, BuilderFigure<? extends Figure>> builder = new HashMap<>();

    public void initialize() {
        builder.put("CIRCLE", new BuilderCircle());
        builder.put("TRIANGLE", new BuilderTriangle());
        builder.put("RECTANGLE", new BuilderRectangle());
    }

    public Figure build(String name, String parameterFigure) throws IllegalArgumentException {
        return builder.get(name).build(parameterFigure);
    }
}

package ru.nsu.popova.model.builderFigure;

import ru.nsu.popova.model.figure.Figure;

import java.util.ArrayList;
import java.util.List;

abstract public class BuilderFigure<T extends Figure> {

    abstract public T build(String parameterList) throws IllegalArgumentException;

    List<Double> parseParameter(String parameterList) throws IllegalArgumentException {
        if (parameterList == null || parameterList.isEmpty()) {
            throw new IllegalArgumentException("Входных данных не достаточно");
        }

        ArrayList<Double> parameters = new ArrayList<>();
        String[] as = parameterList.split(" ");
        for (String str : as) {
            try {
                double valueInput = Double.parseDouble(str.replace(",", "."));
                //if ()
                parameters.add(valueInput/*Double.parseDouble(str.replace(",", "."))*/);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Неверный формат данных");
            }
        }

        return parameters;
    }
}

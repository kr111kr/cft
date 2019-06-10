package ru.nsu.popova.model.builderFigure;

import ru.nsu.popova.model.figure.Circle;

import java.util.List;

public class BuilderCircle extends BuilderFigure<Circle> {

    @Override
    public Circle build(String parameterList) throws IllegalArgumentException {
        List<Double> parameters = parseParameter(parameterList);
        checkParameter(parameters);

        Circle circle = new Circle();
        double radius = parameters.get(0);
        circle.setRadius(radius);
        circle.setDiameter(calculateDiameter(radius));
        circle.setSquare(calculateSquare(radius));
        circle.setPerimeter(calculatePerimeter(radius));
        return circle;
    }

    private void checkParameter(List<Double> parameters) {
        if (parameters.size() != 1) {
            throw new IllegalArgumentException("Не верное количество аргументов!");
        }

        if (parameters.get(0) == 0) {
            throw new IllegalArgumentException("Данные не могут являтся кругом!");
        }
    }

    private double calculateDiameter(double radius) {
        return radius * 2;
    }

    private double calculateSquare(double radius) {
        return Math.PI * radius * radius;
    }

    private double calculatePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }
}

package ru.nsu.popova.model.builderFigure;

import ru.nsu.popova.model.figure.Rectangle;

import java.util.List;

public class BuilderRectangle extends BuilderFigure<Rectangle> {
    @Override
    public Rectangle build(String parameterList) throws IllegalArgumentException {
        List<Double> parameters = parseParameter(parameterList);
        checkParameter(parameters);

        Rectangle rectangle = new Rectangle();
        double length = parameters.get(0);
        double width = parameters.get(1);
        rectangle.setLength(length);
        rectangle.setWidth(width);
        rectangle.setDiagonal(calculateDiagonal(length, width));
        rectangle.setSquare(calculateSquare(length, width));
        rectangle.setPerimeter(calculatePerimeter(length, width));
        return rectangle;
    }

    private void checkParameter(List<Double> parameters) {
        if (parameters.size() != 2) {
            throw new IllegalArgumentException("Не верное количество аргументов!");
        }

        if (parameters.get(0) == 0 || parameters.get(1) == 0) {
            throw new IllegalArgumentException("Данные не могут являться прямоугольником!");
        }
    }

    private double calculateDiagonal(double length, double width) {
        return Math.sqrt(length * length + width * width);
    }

    private double calculateSquare(double length, double width) {
        return length * width;
    }

    private double calculatePerimeter(double length, double width) {
        return 2 * (length + width);
    }
}

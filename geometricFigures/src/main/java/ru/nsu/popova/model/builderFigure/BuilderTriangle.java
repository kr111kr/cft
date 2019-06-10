package ru.nsu.popova.model.builderFigure;

import ru.nsu.popova.model.figure.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuilderTriangle extends BuilderFigure<Triangle> {

    @Override
    public Triangle build(String parameterList) throws IllegalArgumentException {
        List<Double> parameters = parseParameter(parameterList);
        checkParameter(parameters);

        Triangle triangle = new Triangle();
        double a = parameters.get(0);
        double b = parameters.get(1);
        double c = parameters.get(2);

        triangle.setSideA(a);
        triangle.setSideB(b);
        triangle.setSideC(c);
        triangle.setAngleAB(calculateAngleBetweenTwoSide(a, b, c));
        triangle.setAngleBC(calculateAngleBetweenTwoSide(b, c, a));
        triangle.setAngleAC(calculateAngleBetweenTwoSide(a, c, b));
        triangle.setSquare(calculateSquare(a, b, c));
        triangle.setPerimeter(calculatePerimeter(a, b, c));
        return triangle;
    }

    private void checkParameter(List<Double> parameter) {
        if (parameter.size() != 3) {
            throw new IllegalArgumentException("Не верное количество аргументов!");
        }

        List<Integer> listCoef = new ArrayList<>(Arrays.asList(0, 1, 2, 0, 1));
        for (int i = 0; i < 2; ++i) {
            if (parameter.get(i) == 0 || parameter.get(listCoef.get(i)) + parameter.get(listCoef.get(i + 1)) <= parameter.get(listCoef.get(i + 2))) {
                throw new IllegalArgumentException("Данные не могут являться треугольником!");
            }
        }
    }

    private double calculateAngleBetweenTwoSide(double s1, double s2, double s3) {
        return Math.acos((s1 * s1 + s2 * s2 - s3 * s3) / (2 * s1 * s2)) * 180 / Math.PI;
    }

    private double calculateSquare(double a, double b, double c) {
        double polyperimeter = calculatePerimeter(a, b, c) / 2;
        return Math.sqrt(polyperimeter *
                (polyperimeter - a) *
                (polyperimeter - b) *
                (polyperimeter - c));
    }

    private double calculatePerimeter(double a, double b, double c) {
        return a + b + c;
    }
}

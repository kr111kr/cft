package ru.nsu.popova.view.print;

import ru.nsu.popova.model.figure.Circle;
import ru.nsu.popova.model.figure.Figure;

import java.io.IOException;

public class PrintCircle extends PrintFigure {

    @Override
    public String getName() {
        return "Круг";
    }

    @Override
    public void printSpecificParameters(Figure figure) throws IOException {
        if (figure instanceof Circle) {
            Circle circle = (Circle) figure;
            printParameter("Радиус", circle.getRadius(), "мм");
            printParameter("Диаметр", circle.getDiameter(), "мм");
        }
    }
}

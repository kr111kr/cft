package ru.nsu.popova.view.print;

import ru.nsu.popova.model.figure.Figure;
import ru.nsu.popova.model.figure.Triangle;

import java.io.IOException;

public class PrintTriangle extends PrintFigure {

    @Override
    public String getName()
    {
        return "Треугольник";
    }

    @Override
    public void printSpecificParameters(Figure figure) throws IOException {
        if (figure instanceof Triangle) {
            Triangle triangle = (Triangle)figure;
            printParameter("Длина первой стороны", triangle.getSideA(), "мм");
            printParameter("Угол противолежащий первой стороне", triangle.getAngleBC(), "мм");
            printParameter("Длина второй стороны", triangle.getSideB(), "мм");
            printParameter("Угол противолежащий второй стороне", triangle.getAngleAC(), "мм");
            printParameter("Длина третьей стороны", triangle.getSideC(), "мм");
            printParameter("Угол противолежащий третьей стороне", triangle.getAngleAB(), "мм");
        }
    }
}

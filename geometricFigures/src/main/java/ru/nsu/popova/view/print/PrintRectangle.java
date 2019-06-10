package ru.nsu.popova.view.print;

import ru.nsu.popova.model.figure.Figure;
import ru.nsu.popova.model.figure.Rectangle;

import java.io.IOException;

public class PrintRectangle extends PrintFigure{

    @Override
    public String getName()
    {
        return "Прямоугольник";
    }

    @Override
    public void printSpecificParameters(Figure figure) throws IOException
    {
        if (figure instanceof Rectangle) {
            Rectangle rectangle = (Rectangle)figure;
            printParameter("Длина", rectangle.getLength(), "мм");
            printParameter("Ширина", rectangle.getWidth(), "мм");
            printParameter("Диогональ", rectangle.getDiagonal(), "мм");
        }
    }
}

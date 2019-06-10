package ru.nsu.popova.view.print;

import ru.nsu.popova.model.figure.Figure;
import ru.nsu.popova.model.figure.Rectangle;
import ru.nsu.popova.model.figure.Triangle;
import ru.nsu.popova.model.parametr.ParameterUnit;

import java.util.ArrayList;

public class PrintRectangle extends PrintFigure{

    @Override
    public ArrayList<ParameterUnit> getParameter(Figure figure)
    {
        Rectangle rectangle = (Rectangle) figure;
        ArrayList<ParameterUnit> parameterList = new ArrayList<>();
        parameterList.add(getLength(rectangle));
        parameterList.add(getWidth(rectangle));
        parameterList.add(getDiagonal(rectangle));
        parameterList.add(getPerimeter(rectangle));
        parameterList.add(getSquare(rectangle));
        return parameterList;
    }

    public ParameterUnit getLength(Rectangle rectangle)
    {
        return new ParameterUnit("Длина", rectangle.getLength(), "мм");
    }

    public ParameterUnit getWidth(Rectangle rectangle)
    {
        return new ParameterUnit("Ширина", rectangle.getWidth(), "мм");
    }

    public ParameterUnit getDiagonal(Rectangle rectangle)
    {
        return new ParameterUnit("Диогональ", rectangle.getDiagonal(), "мм");
    }





}

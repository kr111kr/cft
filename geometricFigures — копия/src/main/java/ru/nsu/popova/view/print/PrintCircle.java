package ru.nsu.popova.view.print;

import ru.nsu.popova.model.figure.Circle;
import ru.nsu.popova.model.figure.Figure;
import ru.nsu.popova.model.parametr.ParameterUnit;

import java.util.ArrayList;

public class PrintCircle extends PrintFigure{

   /* @Override
    public void print(Figure figure)
    {
        Circle circle = (Circle) figure;
    }*/

    @Override
    public ArrayList<ParameterUnit> getParameter(Figure figure)
    {
        Circle circle = (Circle) figure;
        ArrayList<ParameterUnit> parameterList = new ArrayList<>();
        parameterList.add(getRadius(circle));
        parameterList.add(getDiameter(circle));
        parameterList.add(getPerimeter(circle));
        parameterList.add(getSquare(circle));
        return parameterList;
    }

    public ParameterUnit getRadius(Circle circle)
    {
        return new ParameterUnit("Радиус", circle.getRadius(),"мм");
    }

    public ParameterUnit getDiameter(Circle circle)
    {
        return new ParameterUnit("Диаметр", circle.getDiameter(), "мм");
    }



}

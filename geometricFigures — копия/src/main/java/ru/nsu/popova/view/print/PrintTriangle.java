package ru.nsu.popova.view.print;

import ru.nsu.popova.model.figure.Circle;
import ru.nsu.popova.model.figure.Figure;
import ru.nsu.popova.model.figure.Triangle;
import ru.nsu.popova.model.parametr.ParameterUnit;

import java.util.ArrayList;

public class PrintTriangle extends PrintFigure{

    @Override
    public ArrayList<ParameterUnit> getParameter(Figure figure)
    {
        Triangle triangle = (Triangle) figure;
        ArrayList<ParameterUnit> parameterList = new ArrayList<>();
        parameterList.add(getSindA(triangle));
        parameterList.add(getAngleBC(triangle));
        parameterList.add(getSindB(triangle));
        parameterList.add(getAngleAC(triangle));
        parameterList.add(getSindC(triangle));
        parameterList.add(getAngleAB(triangle));
        parameterList.add(getPerimeter(triangle));
        parameterList.add(getSquare(triangle));
        return parameterList;
    }

    public ParameterUnit getSindA(Triangle triangle)
    {
        return new ParameterUnit("Длина первой стороны", triangle.getA(), "мм");
    }

    public ParameterUnit getSindB(Triangle triangle)
    {
        return new ParameterUnit("Длина второй стороны", triangle.getB(), "мм");
    }

    public ParameterUnit getSindC(Triangle triangle)
    {
        return new ParameterUnit("Длина третьей стороны", triangle.getC(), "мм");
    }

    public ParameterUnit getAngleBC(Triangle triangle)
    {
        return new ParameterUnit("Угол противолежащий первой стороне", triangle.getAngleBC(), "мм");
    }

    public ParameterUnit getAngleAC(Triangle triangle)
    {
        return new ParameterUnit("Угол противолежащий второй стороне", triangle.getAngleAC(), "мм");
    }

    public ParameterUnit getAngleAB(Triangle triangle)
    {
        return new ParameterUnit("Угол противолежащий третьей стороне", triangle.getAngleAB(), "мм");
    }



}

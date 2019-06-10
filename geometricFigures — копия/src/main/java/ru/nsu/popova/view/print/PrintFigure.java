package ru.nsu.popova.view.print;

import ru.nsu.popova.model.figure.Circle;
import ru.nsu.popova.model.figure.Figure;
import ru.nsu.popova.model.parametr.ParameterUnit;

import java.util.ArrayList;
import java.util.List;

public class PrintFigure <T extends Figure> {

    public void print(Figure figure)
    {
        ArrayList<ParameterUnit> ar = getParameter(figure);
        printName(figure.getName());
        printParameter(ar);
    }

    public ArrayList<ParameterUnit> getParameter(Figure figure)
    {
        return null;
    }

    public void printName(String nameFigure)
    {
        System.out.println("Тип фигуры: " + nameFigure);
    }

    public void printParameter(List<ParameterUnit> listParametr)
    {
        for (ParameterUnit parametr: listParametr) {
            System.out.println(parametr.getName() + ": " + parametr.getValue() + " " + parametr.getUnit());
        }
    }

    public ParameterUnit getSquare(Figure figure)
    {
        return new ParameterUnit("Площадь", figure.getSquare(), "кв.мм");
    }


    public ParameterUnit getPerimeter(Figure figure)
    {
        return new ParameterUnit("Периметр", figure.getPerimeter(), "мм");
    }
}

package ru.nsu.popova.model.figure;

import ru.nsu.popova.model.parametr.ParameterUnit;

import java.util.List;

public class Figure {
    private String nameFigure;
    // private ParameterUnit perimeterFigure;
    //private ParameterUnit squareFigure;

    private double perimeterFigure;
    private double squareFigure;

    public Figure(String nameFigure) {
        this.nameFigure = nameFigure;
    }

    public void readInput() {};

    public String getName(){
        return nameFigure;
    }

    public double getPerimeter()
    {
        return perimeterFigure;
    }

    public double getSquare()
    {
        return squareFigure;
    }

    public void setPerimeter(double perimeter)
    {
        this.perimeterFigure = perimeter;
    }

    public void setSquare(double square)
    {
        this.squareFigure = square;
    }

    public List<ParameterUnit> getParametr()
    {
        return null;
    }

    enum Figureyt{
        CIRCLE,
        TRIANGLE,
        RECTANGLE
    }
}

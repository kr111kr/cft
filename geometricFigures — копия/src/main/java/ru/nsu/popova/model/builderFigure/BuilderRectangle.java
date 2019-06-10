package ru.nsu.popova.model.builderFigure;

import ru.nsu.popova.model.figure.Circle;
import ru.nsu.popova.model.figure.Rectangle;

import java.util.ArrayList;

public class BuilderRectangle extends BuilderFigure<Rectangle> {
    @Override
    public Rectangle build(ArrayList<String> parameterList){
        ArrayList<Double> parameterListDouble = new ArrayList<>();

        try {
            parameterListDouble = parseParameter(parameterList);
            checkParameter(parameterListDouble);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Rectangle rectangle = new Rectangle();
        double length = parameterListDouble.get(0);
        double width = parameterListDouble.get(1);
        rectangle.setLength(length);
        rectangle.setWidth(width);
        rectangle.setDiagonal(calculateDiagonal(length, width));
        rectangle.setSquare(calculateSquare(length, width));
        rectangle.setPerimeter(calculatePerimeter(length, width));
        return rectangle;
    }

    private void checkParameter(ArrayList<Double> parameterListDouble) throws Exception
    {
        if (parameterListDouble == null || parameterListDouble.size() < 2)
        {
            throw new IllegalArgumentException("Аргументов не достаточно!");
            //return false;
        }
        //return true;
    }

    private ArrayList<Double> parseParameter(ArrayList<String> parameterList) throws Exception
    {
        if (parameterList == null || parameterList.size() < 1)
        {
            throw new IllegalArgumentException("Входных данных не достаточно");
        }


        ArrayList<Double> parameterListDouble = new ArrayList<>();
        for (String stringParameter : parameterList)
        {
            String[] as = stringParameter.split(" ");
            for (String str : as) {
                parameterListDouble.add(Double.parseDouble(str.replace(",", ".")));
            }
        }

        // ArrayList<Double> parameterListDouble = new ArrayList<>();
        return parameterListDouble;
    }

    public double calculateDiagonal(double length, double width)
    {
        return Math.sqrt(length * length + width * width);
    }

    public double calculateSquare(double length, double width)
    {
        return length * width;
    }

    public double calculatePerimeter(double length, double width)
    {
        return 2 * (length + width);
    }
}

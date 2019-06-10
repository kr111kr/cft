package ru.nsu.popova.model.builderFigure;

import ru.nsu.popova.model.figure.Circle;

import java.util.ArrayList;

public class BuilderCircle extends BuilderFigure<Circle> {

    @Override
    public  Circle build(ArrayList<String> parameterList){
        ArrayList<Double> parameterListDouble = new ArrayList<>();

        try {
            parameterListDouble = parseParameter(parameterList);
            checkParameter(parameterListDouble);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Circle circle = new Circle();
        circle.setRadius(parameterListDouble.get(0));
        circle.setDiameter(calculateDiameter(circle.getRadius()));
        circle.setSquare(calculateSquare(circle.getRadius()));
        circle.setPerimeter(calculatePerimeter(circle.getRadius()));
        return circle;
    }

    private void checkParameter(ArrayList<Double> parameterListDouble) throws Exception
    {
        if (parameterListDouble == null || parameterListDouble.size() < 1)
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
                parameterListDouble.add(Double.parseDouble(str.replace(".", ",")));
            }
        }

       // ArrayList<Double> parameterListDouble = new ArrayList<>();
        return parameterListDouble;
    }

    public double calculateDiameter(double radius)
    {
        return radius * 2;
    }

    public double calculateSquare(double radius)
    {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter(double radius)
    {
        return 2 * Math.PI * radius;
    }
}

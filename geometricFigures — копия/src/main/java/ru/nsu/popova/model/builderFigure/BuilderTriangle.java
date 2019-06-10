package ru.nsu.popova.model.builderFigure;

import ru.nsu.popova.model.figure.Circle;
import ru.nsu.popova.model.figure.Triangle;

import java.util.ArrayList;

public class BuilderTriangle extends BuilderFigure<Triangle> {

    @Override
    public Triangle build(ArrayList<String> parameterList){
        ArrayList<Double> parameterListDouble = new ArrayList<>();

        try {
            parameterListDouble = parseParameter(parameterList);
            checkParameter(parameterListDouble);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Triangle triangle = new Triangle();
        double a = parameterListDouble.get(0);
        double b = parameterListDouble.get(1);
        double c = parameterListDouble.get(2);

        triangle.setABC(a, b, c);
        triangle.setAngleAB(calculateAngleBetweenTwoSide(a, b, c));
        triangle.setAngleBC(calculateAngleBetweenTwoSide(b, c, a));
        triangle.setAngleAC(calculateAngleBetweenTwoSide(a, c, b));
        triangle.setSquare(calculateSquare(a, b, c));
        triangle.setPerimeter(calculatePerimeter(a, b, c));
        return triangle;
    }


    private void checkParameter(ArrayList<Double> parameterListDouble) throws Exception
    {
        if (parameterListDouble == null || parameterListDouble.size() < 3)
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

    public double calculateAngleBetweenTwoSide(double s1, double s2, double s3)
    {
        return Math.acos((s1 * s1 + s2 * s2 - s3 * s3) / (2 * s1 * s2)) * 180 / Math.PI;
    }

    public double calculateSquare(double a, double b, double c)
    {
        double polyperimeter = calculatePerimeter(a, b, c) / 2;
        return Math.sqrt(polyperimeter *
                (polyperimeter - a) *
                (polyperimeter - b) *
                (polyperimeter - c));
    }

    public double calculatePerimeter(double a, double b, double c)
    {
        return a + b + c;
    }

}

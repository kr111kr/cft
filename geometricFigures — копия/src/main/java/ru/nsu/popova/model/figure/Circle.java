package ru.nsu.popova.model.figure;

import ru.nsu.popova.model.parametr.ParameterUnit;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Circle extends Figure {

    private double radius;
    private double diameter;

    public Circle() {
        super("Круг");
    }

    @Override
    public void readInput() {

        Scanner scan = new Scanner(System.in);

        try {
            if (scan.hasNext())
            {
                radius = Double.parseDouble(scan.nextLine());//.toUpperCase();
            }
            System.out.println(radius + "  cc");
        } catch (Exception e) {
            throw new IllegalArgumentException("Вы ввели не число!");
        }
    }

  /*  public ParameterUnit getRadius()
    {
        return new ParameterUnit("Радиус", radius, "мм");
    }
*/
 /*   public ParameterUnit getRadius()
    {
        return radius;
    }
*/

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double/*ParameterUnit*/ getDiameter()
    {
        return diameter;//new ParameterUnit("Диаметр", radius * 2, "мм");
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    /*@Override
    public ParameterUnit getSquare()
    {
        return new ParameterUnit("Площадь", Math.PI * radius * radius, "кв.мм");
    }

    @Override
    public ParameterUnit getPerimeter()
    {
        return new ParameterUnit("Периметр", 2 * Math.PI * radius, "мм");
    }*/



   /* @Override
    public List<ParameterUnit> getParametr()
    {
        return Arrays.asList(getRadius(), getDiameter(), getPerimeter(), getSquare());
    }*/



}

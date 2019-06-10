package ru.nsu.popova.model.figure;

import ru.nsu.popova.model.parametr.ParameterUnit;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Rectangle extends Figure {
    private double length;
    private double width;
    private double diagonal;

    public Rectangle() {
        super("Прямоугольник");
    }

    @Override
    public void readInput() {

        Scanner scan = new Scanner(System.in);

        try {
            if (scan.hasNext())
            {
                length = scan.nextDouble();
                if (scan.hasNext())
                {
                    width = scan.nextDouble();
                }
            }

            System.out.println(length + "  "  + width);
        } catch (Exception e) {
            throw new IllegalArgumentException("Вы ввели не число!");
        }
    }

    public double getLength()
    {
        return length;//new ParameterUnit("Длина", length, "мм");
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth()
    {
        return width;//new ParameterUnit("Ширина", width, "мм");
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getDiagonal()
    {
        return diagonal;//new ParameterUnit("Длина диогонали", Math.sqrt(length * length + width * width), "мм");
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public List<ParameterUnit> getParametr()
    {
        return null;//Arrays.asList(getLength(), getWidth(), getDiagonal(), getPerimeter(), getSquare());
    }


}

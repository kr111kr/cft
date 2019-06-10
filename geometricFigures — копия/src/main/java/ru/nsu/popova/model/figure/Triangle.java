package ru.nsu.popova.model.figure;

import ru.nsu.popova.model.parametr.ParameterUnit;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Triangle extends Figure{

    private double sindA;
    private double sindB;
    private double sindC;
    private double angleAB;
    private double angleBC;
    private double angleAC;

    public Triangle() {
        super("Треугольник");
    }

   // @Override
    /*public void readInput() {

        Scanner scan = new Scanner(System.in);

        try {
            if (scan.hasNextDouble())
            {
                a = scan.nextDouble();
                if (scan.hasNextDouble())
                {
                    b = scan.nextDouble();
                    if (scan.hasNextDouble())
                    {
                        c = scan.nextDouble();
                    }
                }
            }

            System.out.println(a + "  "  + b + "  " + c);
        } catch (Exception e) {
            throw new IllegalArgumentException("Вы ввели не число!");
        }
    }
*/

    public double getA()
    {
        return sindA;//new ParameterUnit("Длина первой стороны", a, "мм");
    }

    public void setA(double a) {
        this.sindA = a;
    }

    public double getB()
    {
        return sindB;//new ParameterUnit("Длина второй стороны", b, "мм");
    }


    public void setB(double b) {
        this.sindB = b;
    }

    public double getC()
    {
        return sindC;//new ParameterUnit("Длина третьей стороны", c, "мм");
    }


    public void setC(double c) {
        this.sindC = c;
    }


    public void setABC(double a, double b, double c) {
        this.sindA = a;
        this.sindB = b;
        this.sindC = c;
    }

    public double getAngleAB() {
        return angleAB;
    }

    public void setAngleAB(double angleAB) {
        this.angleAB = angleAB;
    }

    public double getAngleBC() {
        return angleBC;
    }

    public void setAngleBC(double angleBC) {
        this.angleBC = angleBC;
    }

    public double getAngleAC() {
        return angleAC;
    }

    public void setAngleAC(double angleAC) {
        this.angleAC = angleAC;
    }

  /*  @Override
    public List<ParameterUnit> getParametr()
    {
        return null*//*Arrays.asList(getA(), new ParameterUnit("Угол противолежащий первой стороне", getAngleAB(b, c, a), "градусов"),
                getB(), new ParameterUnit("Угол противолежащий второй стороне", getAngleAB(a, c, b), "градусов"),
                getC(), new ParameterUnit("Угол противолежащий третьей стороне", getAngleAB(b, a, c), "градусов"),
                getPerimeter(), getSquare())*//*;
    }*/
}

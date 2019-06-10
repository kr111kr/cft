package ru.nsu.popova.model.figure;

public class Triangle extends Figure {

    private double sideA;
    private double sideB;
    private double sideC;
    private double angleAB;
    private double angleBC;
    private double angleAC;

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double a) {
        this.sideA = a;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double b) {
        this.sideB = b;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double c) {
        this.sideC = c;
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

}

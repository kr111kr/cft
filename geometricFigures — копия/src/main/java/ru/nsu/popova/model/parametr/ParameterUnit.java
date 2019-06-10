package ru.nsu.popova.model.parametr;

public class ParameterUnit {
    private String name;
    private double value;
    private String unit;

    public ParameterUnit(String name, double value, String unit) {
        this.name = name;
        this.value = value;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getParametrString()
    {
        return name + ": " + value + " " + unit + "\n";
    }
}

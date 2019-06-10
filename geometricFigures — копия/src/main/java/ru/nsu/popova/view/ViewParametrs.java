package ru.nsu.popova.view;

import ru.nsu.popova.model.parametr.ParameterUnit;

import java.util.List;

public class ViewParametrs {

    public void printData(String nameFigure, List<ParameterUnit> listParametr) {
        printName(nameFigure);
        printParametr(listParametr);

    }

    public void printName(String nameFigure)
    {
        System.out.println("Тип фигуры: " + nameFigure);
    }

    public void printParametr(List<ParameterUnit> listParametr)
    {
        for (ParameterUnit parametr: listParametr) {
            System.out.println(parametr.getName() + ": " + parametr.getValue() + " " + parametr.getUnit());
        }
    }
}

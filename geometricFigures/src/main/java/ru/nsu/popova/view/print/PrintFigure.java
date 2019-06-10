package ru.nsu.popova.view.print;

import ru.nsu.popova.model.figure.Figure;

import java.io.FileWriter;
import java.io.IOException;

public abstract class PrintFigure<T extends Figure> {

    private FileWriter fileWriter;

    public void print(T figure) throws IOException {
        fileWriter = newFileWriter();
        printName(getName());
        printParameter("Периметр", figure.getPerimeter(), "мм");
        printParameter("Площадь", figure.getSquare(), "кв.мм");
        printSpecificParameters(figure);
        fileWriter.close();
    }

    private FileWriter newFileWriter() throws IOException {
        return new FileWriter("./src/main/resources/output.txt");
    }

    abstract public void printSpecificParameters(T figure) throws IOException;

    abstract public String getName();

    private void printName(String nameFigure) throws IOException {
        fileWriter.write("Тип фигуры: " + nameFigure + "\n");
    }

    void printParameter(String name, double value, String unit) throws IOException {
        fileWriter.write(name + ": " + value + " " + unit + "\n");
    }
}

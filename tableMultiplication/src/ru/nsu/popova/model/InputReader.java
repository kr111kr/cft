package ru.nsu.popova.model;

import ru.nsu.popova.objects.Table;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputReader {

    private Table table;

    public InputReader() {
        this.table = new Table();
    }

    public void readInput()
    {
        table.setTableSize(getInputValue());
        table.setLenMaxValue(Integer.toString(table.getTableSize() * table.getTableSize()).length());
    }

    public Table getTable() {
        return table;
    }

    private int getInputValue() {
        do
        {
            try {
                int n = readHint();
                checkInputValue(n);
                return n;
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
        while (true);
    }

    private void checkInputValue(Integer n) throws IllegalArgumentException {

        if (n > 32) {
            throw new IllegalArgumentException("Число должно быть не больше 32, введите заново");
        } else if (n < 1) {
            throw new IllegalArgumentException("Число должно быть не меньше 1, введите заново");
        }
    }

    private int readHint() throws IllegalArgumentException {
        System.out.println("Введите число от 1 до 32:  ");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {
            return Integer.parseInt(bf.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("Вы ввели не число!");
        }
    }
}

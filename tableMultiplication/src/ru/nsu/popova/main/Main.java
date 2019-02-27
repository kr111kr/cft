package ru.nsu.popova.main;

import ru.nsu.popova.model.InputReader;
import ru.nsu.popova.view.ViewTable;

public class Main {

    public static void main(String args[]) {

        InputReader model = new InputReader();
        model.readInput();

        ViewTable viewTable = new ViewTable();
        viewTable.printTable(model.getTable());
    }
}

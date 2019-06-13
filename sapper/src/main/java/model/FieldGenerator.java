package model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FieldGenerator {

    public Field createField(GameConfiguration gameConfiguration) {
        Field field = new Field(gameConfiguration);
        for (int i = 0; i < field.getGameConfiguration().getWidth(); ++i) {
            for (int j = 0; j < field.getGameConfiguration().getHeight(); ++j) {
                field.getField()[i][j] = new Cell(i, j);
            }
        }
        return field;
    }

    private void print(Field field) {
        for (int i = 0; i < field.getGameConfiguration().getWidth(); ++i) {
            for (int j = 0; j < field.getGameConfiguration().getHeight(); ++j) {
                System.out.print(field.getField()[i][j].isBomb() ? "*  " : field.getField()[i][j].getCountBomb() + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private List<Pair<Integer, Integer>> circleXY(Field field, int a, int b) {
        List<Pair<Integer, Integer>> circleXY = new ArrayList<>();
        for (int offsetX = -1; offsetX <= 1; offsetX++) {
            for (int offsetY = -1; offsetY <= 1; offsetY++) {
                if (!outBounds(field, offsetX + a, offsetY + b)) {
                    circleXY.add(new Pair<>(offsetX + a, offsetY + b));
                }
            }
        }
        return circleXY;
    }

    public void generateMine(Field field, int a, int b) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        List<Pair<Integer, Integer>> circle = circleXY(field, a, b);
        for (int i = 0; i < field.getGameConfiguration().getWidth(); i++) {
            for (int j = 0; j < field.getGameConfiguration().getHeight(); j++) {
                if (!circle.contains(new Pair(i, j)))
                {
                    list.add(new Pair(i, j));
                }
            }
        }

        Collections.shuffle(list);

        for (int i = 0; i < field.getGameConfiguration().getCountBomb(); i++) {
            field.getField()[list.get(i).getKey()][list.get(i).getValue()].setBomb(true);
        }

        for (int i = 0; i < field.getGameConfiguration().getWidth(); i++) {
            for (int j = 0; j < field.getGameConfiguration().getHeight(); j++) {
                field.getField()[i][j].setOpen(false);
                field.getField()[i][j].setFirstOpenBomb(false);
                field.getField()[i][j].setCountBomb(calcNear(field, i, j));
            }
        }

        print(field);
    }

    private int calcNear(Field field, int x, int y) {
        int count = 0;
        for (int offsetX = -1; offsetX <= 1; offsetX++) {
            for (int offsetY = -1; offsetY <= 1; offsetY++) {
                if (outBounds(field, offsetX + x, offsetY + y)) {
                    continue;
                }

                count += field.getField()[offsetX + x][offsetY + y].isBomb() ? 1 : 0;
            }
        }
        return count;
    }

    private boolean outBounds(Field field, int x, int y) {
        return x < 0 || y < 0 || x >= field.getGameConfiguration().getWidth() || y >= field.getGameConfiguration().getHeight();
    }
}

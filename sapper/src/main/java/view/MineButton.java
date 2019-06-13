package view;

import model.Cell;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class MineButton extends JButton {
    private TexturesCells texturesCells;

    private Cell cell;

    public MineButton(Cell cell, TexturesCells texturesCells) {
        this.cell = cell;

        this.texturesCells = texturesCells;
    }

    public void repaintCell() {
        if (cell.isOpen()) {
            setEnabled(false);
            if (cell.isBomb()) {
                if (cell.getIsFlag() != 1) {
                    setDisabledIcon(texturesCells.getBombImage());
                    setIcon(texturesCells.getBombImage());
                    if (cell.isFirstOpenBomb()) {
                        setBackground(Color.red);
                    }
                } else {
                    setDisabledIcon(texturesCells.getFlagImage());
                    setBackground(new ColorUIResource(202, 255, 112));
                }
            } else if (cell.getCountBomb() > 0 && cell.getCountBomb() <= 9) {
                setDisabledIcon(texturesCells.getValueImage(cell.getCountBomb()));
                setIcon(texturesCells.getValueImage(cell.getCountBomb()));
                if (cell.getIsFlag() != 0) {
                    setIcon(texturesCells.getFlagImage());
                    setBackground(Color.pink);
                }
            }
        } else {
            switch (cell.getIsFlag()) {
                case 0:
                    setIcon(null);
                    break;
                case 1:
                    setIcon(texturesCells.getFlagImage());
                    break;
                case 2:
                    setIcon(texturesCells.getQuestionImage());
                    break;
            }
        }
    }
}

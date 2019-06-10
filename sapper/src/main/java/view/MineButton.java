package view;

import model.Cell;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class MineButton extends JButton {
    private Textures textures;

    private Cell cell;

    public MineButton(Cell cell, Textures textures) {
        this.cell = cell;

        this.textures = textures;
    }

    public Cell getCell() {
        return cell;
    }

    public void repaintCell(/*Cell cell*/) {
        if (cell.isOpen()) {
            //setContentAreaFilled(false);
           /* setBackground(Color.GRAY);
            setForeground(Color.GRAY);
            */
          //  setRequestFocusEnabled(false);
        //   setFocusPainted(false);
            setEnabled(false);
            if (cell.isBomb()) {
                if (cell.getIsFlag() != 1) {
                    setDisabledIcon(textures.getBombImage());
                    setIcon(textures.getBombImage());
                    if (cell.isFirstOpenBomb()) {
                        setBackground(Color.red);
                    }
                }
                else {
                    setDisabledIcon(textures.getFlagImage());
                    setBackground(new ColorUIResource(202,255, 112));
                }
            } else if (cell.getCountBomb() > 0 && cell.getCountBomb() <= 9) {
                setDisabledIcon(textures.getValueImage(cell.getCountBomb()));
                setIcon(textures.getValueImage(cell.getCountBomb()));
                if (cell.getIsFlag() != 0)
                {
                    setIcon(textures.getFlagImage());
                    setBackground(Color.pink);
                }
            }
        } else {
            switch (cell.getIsFlag()) {
                case 0:
                    setIcon(null);
                    break;
                case 1:
                    setIcon(textures.getFlagImage());
                    break;
                case 2:
                    setIcon(textures.getQuestionImage());
                    break;
            }
        }
    }
}

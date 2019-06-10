package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class TexturesPanel {
    private ImageIcon newGame;
    private ImageIcon gameWins;
    private ImageIcon gameLoss;

    public TexturesPanel() throws IOException {
        newGame = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("icons/" + "newGame.png")));
        gameWins = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("icons/" + "gameWins.png")));
        gameLoss = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("icons/" + "gameLoss.png")));
    }

    public ImageIcon getNewGame() {
        return newGame;
    }

    public ImageIcon getGameWins() {
        return gameWins;
    }

    public ImageIcon getGameLoss() {
        return gameLoss;
    }
}

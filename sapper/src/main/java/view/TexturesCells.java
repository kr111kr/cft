package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TexturesCells {

    private List<ImageIcon> valueImage;
    private ImageIcon bombImage;
    private ImageIcon questionImage;
    private ImageIcon flagImage;

    public TexturesCells() throws IOException {
        valueImage = new ArrayList<>();
        String path = "icons/";
        for (int i = 0; i < 10; ++i)
        {
            valueImage.add(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(path + i + ".png"))));
        }

        bombImage = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(path +"bomb.png")));
        questionImage = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(path +"question.png")));
        flagImage = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(path +"flag.png")));
    }

    public ImageIcon getQuestionImage() {
        return questionImage;
    }

    public ImageIcon getFlagImage() {
        return flagImage;
    }

    public ImageIcon getValueImage(int value) {
        return valueImage.get(value);
    }

    public ImageIcon getBombImage() {
        return bombImage;
    }
}

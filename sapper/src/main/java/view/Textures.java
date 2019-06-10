package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Textures {

    private List<ImageIcon> valueImage;
    private ImageIcon bombImage;
    private ImageIcon questionImage;
    private ImageIcon flagImage;

    public Textures() throws IOException {
        valueImage = new ArrayList<>();
        for (int i = 0; i < 10; ++i)
        {
            valueImage.add(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("icons/" + i + ".png"))));
        }

        bombImage = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("icons/" +"bomb.png")));
        questionImage = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("icons/" +"question.png")));
        flagImage = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("icons/" +"flag.png")));
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

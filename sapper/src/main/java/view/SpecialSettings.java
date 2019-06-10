package view;

import controler.Controller;
import controler.StatisticController;
import model.GameConfiguration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.SwingConstants.HORIZONTAL;

public class SpecialSettings {


    private JFrame specialFrame;
    private JPanel panel;

    private List<JLabel> texts;
    private List<JTextField> fieldsValue;
    private List<JSlider> slidersCountBomb;

    /*private JLabel textHeight;
    private JLabel textWidth;
    private JLabel textCountBomb;
    private JTextField fieldHeight;
    private JTextField fieldWidth;
    private JTextField fieldCountBomb;
    private JSlider sliderHeight;
    private JSlider sliderWidth;
    private JSlider sliderCountBomb;
*/

    private JButton okButton;
    private JButton cancelButton;


    public SpecialSettings(Controller controller) throws HeadlessException {
        specialFrame = new JFrame("Специальное поле");
        specialFrame.setSize(new Dimension(250, 210));
        specialFrame.setMinimumSize(new Dimension(250, 380));
        // specialFrame.setPreferredSize(new Dimension(4500, 610));
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        texts = new ArrayList<>();
        fieldsValue = new ArrayList<>();
        slidersCountBomb = new ArrayList<>();
        addHeightParameter(0, "Ширина(от 5 до 65): ", 5, 65, 9);
        addHeightParameter(1, "Высота(от 5 до 32):", 5, 32, 9);
        addHeightParameter(2, "Количество бомб: ", 5, ((Double)(9 * 9 * 0.9)).intValue(), 10);

        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(90, 30));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Okay");
                controller.newGame(new GameConfiguration("Specific",
                        Integer.valueOf(fieldsValue.get(0).getText()),
                        Integer.valueOf(fieldsValue.get(1).getText()),
                        Integer.valueOf(fieldsValue.get(2).getText()),
                        false));
                specialFrame.dispose();
            }
        });

        cancelButton = new JButton("CANCEL");
        cancelButton.setPreferredSize(new Dimension(90, 30));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancel");

                specialFrame.dispose();
            }
        });

        JPanel grid = new JPanel(new GridLayout(1, 2, 5, 8));
        grid.add(okButton);
        grid.add(cancelButton);

        panel.add(grid);

        specialFrame.add(panel);

        specialFrame.setResizable(false);
        specialFrame.setVisible(true);
    }


    private void addHeightParameter(int kod, String text, int minValue, int maxValue, int startValue) {
        JPanel panelHeight = new JPanel();
        panelHeight.setPreferredSize(new Dimension(250, 90));
        texts.add(kod, new JLabel(text));

        fieldsValue.add(kod, new JTextField());
        fieldsValue.get(kod).setPreferredSize(new Dimension(30, 30));
        fieldsValue.get(kod).setFocusable(false);

        slidersCountBomb.add(kod, new JSlider(HORIZONTAL, minValue, maxValue, startValue));
        fieldsValue.get(kod).setText(String.valueOf(slidersCountBomb.get(kod).getValue()));

        if (kod != 2) {
            slidersCountBomb.get(kod).setMajorTickSpacing(10);
        } else {
            int s = (slidersCountBomb.get(2).getMaximum() - slidersCountBomb.get(2).getMinimum()) / 6;
            slidersCountBomb.get(kod).setMajorTickSpacing(s);
            slidersCountBomb.get(kod).setLabelTable(slidersCountBomb.get(kod).createStandardLabels(s));

        }
        slidersCountBomb.get(kod).setMinorTickSpacing(1);
        //   slidersCountBomb.get(kod).setSnapToTicks(true);
        slidersCountBomb.get(kod).setPaintTicks(true);
        slidersCountBomb.get(kod).setPaintLabels(true);

        panelHeight.add(texts.get(kod));
        panelHeight.add(fieldsValue.get(kod));
        panelHeight.add(slidersCountBomb.get(kod));

        slidersCountBomb.get(kod).addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                if (kod == 0 || kod == 1) {
                    updateParameterSlider();
                }

                jSlider1StateChanged(kod);
            }
        });

        panel.add(panelHeight);
    }

    private void jSlider1StateChanged(int kod) {
        fieldsValue.get(kod).setText(String.valueOf(slidersCountBomb.get(kod).getValue()));
    }

    private void updateParameterSlider() {
        slidersCountBomb.get(2).setMaximum(((Double) (slidersCountBomb.get(0).getValue() * slidersCountBomb.get(1).getValue() * 0.9)).intValue());
        int s = (slidersCountBomb.get(2).getMaximum() - slidersCountBomb.get(2).getMinimum()) / 6;
        slidersCountBomb.get(2).setMajorTickSpacing(s);
        slidersCountBomb.get(2).setLabelTable(slidersCountBomb.get(2).createStandardLabels(s));

    }
}

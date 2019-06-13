package view;

import controler.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.SwingConstants.HORIZONTAL;

public class SpecialSettings {

    private final Double PERCENT_BOMB = 0.9;
    private final int SEPARATION_STEP = 6;
    private final int START_VALUE =9;
    private JFrame specialFrame;
    private JPanel panel;

    private List<JLabel> texts;
    private List<JTextField> fieldsValue;
    private List<JSlider> slidersCountBomb;

    private JButton okButton;
    private JButton cancelButton;


    public SpecialSettings(Controller controller) throws HeadlessException {
        specialFrame = new JFrame("Специальное поле");
        specialFrame.setSize(new Dimension(250, 210));
        specialFrame.setMinimumSize(new Dimension(250, 380));

        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        texts = new ArrayList<>();
        fieldsValue = new ArrayList<>();
        slidersCountBomb = new ArrayList<>();
        addHeightParameter(0, "Ширина(от 5 до 65): ", 5, 65, 9);
        addHeightParameter(1, "Высота(от 5 до 32):", 5, 32, 9);
        addHeightParameter(2, "Количество бомб: ", 5, ((Double) (9 * 9 * PERCENT_BOMB)).intValue(), 10);

        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(90, 30));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int height = Integer.valueOf(fieldsValue.get(0).getText());
                int width = Integer.valueOf(fieldsValue.get(1).getText());
                int countBomb = Integer.valueOf(fieldsValue.get(2).getText());
                System.out.println("Okay");
                controller.newGame(controller.getDefaultConfigurationField().getGameConfigurationsToParameter(height, width, countBomb));
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
            slidersCountBomb.get(kod).setLabelTable(slidersCountBomb.get(kod).createStandardLabels(countMajorLabel()));

        }
        slidersCountBomb.get(kod).setMinorTickSpacing(1);
        slidersCountBomb.get(kod).setPaintTicks(true);
        slidersCountBomb.get(kod).setPaintLabels(true);

        panelHeight.add(texts.get(kod));
        panelHeight.add(fieldsValue.get(kod));
        panelHeight.add(slidersCountBomb.get(kod));

        slidersCountBomb.get(kod).addChangeListener(evt -> {
            if (kod == 0 || kod == 1) {
                updateParameterSlider();
            }

            jSlider1StateChanged(kod);
        });

        panel.add(panelHeight);
    }

    private int countMajorLabel() {
        return (slidersCountBomb.get(2).getMaximum() - slidersCountBomb.get(2).getMinimum()) / SEPARATION_STEP;
    }

    private void jSlider1StateChanged(int kod) {
        fieldsValue.get(kod).setText(String.valueOf(slidersCountBomb.get(kod).getValue()));
    }

    private void updateParameterSlider() {
        slidersCountBomb.get(2).setMaximum(((Double) (slidersCountBomb.get(0).getValue() *
                                                    slidersCountBomb.get(1).getValue() *
                                                    PERCENT_BOMB)).intValue());
        slidersCountBomb.get(2).setLabelTable(slidersCountBomb.get(2).createStandardLabels(countMajorLabel()));

    }
}

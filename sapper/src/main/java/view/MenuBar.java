package view;

import controler.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuBar extends JMenuBar
{

    private static final int WIDTH = 20;
    private static final Dimension MIN_SIZE = new Dimension(WIDTH, 30);

    public MenuBar(Controller controller)
    {
        setSize(MIN_SIZE);
        setMinimumSize(MIN_SIZE);
        setPreferredSize(MIN_SIZE);

        setLayout(new BorderLayout());
        add(new JMenu("Файл"));

        JMenuItem newGame = new JMenuItem("Новая игра");

        List<JMenuItem> newNameGame = new ArrayList<>();
        for (String name : controller.getDefaultConfigurationField().getNames()){
            JMenuItem temp = new JMenuItem(name);
            temp.addActionListener(arg0 -> {
                System.out.println ("ActionListener.actionPerformed : open");
                controller.newGame(controller.getDefaultConfigurationField().getGameConfigurationsToName(name));
            });
            newNameGame.add(temp);
        }

        JMenuItem special = new JMenuItem("Особые");
        JMenuItem statistic = new JMenuItem("Статистика");

        getMenu(0).add(newGame);
        getMenu(0).addSeparator();

        for (JMenuItem jMenuItem : newNameGame) {
            getMenu(0).add(jMenuItem);
        }

        getMenu(0).add(special);
        getMenu(0).add(statistic);

        setVisible(true);
        newGame.addActionListener(arg0 -> {
            System.out.println ("ActionListener.actionPerformed : open");
            controller.newGame();
        });


        special.addActionListener(arg0 -> {
            System.out.println ("ActionListener.actionPerformed : open");
            controller.getOpenSpecialSettings();
        });

        statistic.addActionListener(arg0 ->{
            System.out.println("statics");
            try {
                controller.getStatisticController().openWindow(0);
            } catch (IOException e) {
                controller.getStatisticController().errorWindowView(e);
                e.printStackTrace();
            }
        });
    }
}

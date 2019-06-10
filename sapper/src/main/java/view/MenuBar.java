package view;

import controler.Controller;
import controler.StatisticController;
import model.GameConfiguration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuBar extends JMenuBar
{

    private static final int WIDTH = 20;
    private static final int COMPONENT_HEIGHT = 30;
    private static final Dimension MIN_SIZE = new Dimension(WIDTH, 30);
    private static final Dimension COMPONENT_SIZE = new Dimension(WIDTH, COMPONENT_HEIGHT);

    public MenuBar(Controller controller)
    {
       // setLocation(0, 0);
        setSize(MIN_SIZE);
        setMinimumSize(MIN_SIZE);
        setPreferredSize(MIN_SIZE);

        setLayout(new BorderLayout());
        // Создание выпадающего меню
        add(new JMenu("Файл"));
        // Пункт меню "Открыть" с изображением

        JMenuItem newGame = new JMenuItem("Новая игра"/*,
                new ImageIcon("images/open.png")*/);

        List<JMenuItem> newNameGame = new ArrayList<>();
        for (String name : controller.getDefaultConfiguration().getNames()){
            JMenuItem temp = new JMenuItem(name);
            temp.addActionListener(arg0 -> {
                System.out.println ("ActionListener.actionPerformed : open");
                controller.newGame(controller.getDefaultConfiguration().getGameConfigurationsToName(name));
            });
            newNameGame.add(temp);
        }

        /*JMenuItem starter = new JMenuItem("Новичок"*//*,
                new ImageIcon("images/open.png")*//*);

        JMenuItem normal = new JMenuItem("Любитель"*//*,
                new ImageIcon("images/open.png")*//*);

        JMenuItem profi = new JMenuItem("Профессионал"*//*,
                new ImageIcon("images/open.png")*//*);*/
        JMenuItem special = new JMenuItem("Особые"/*,
                new ImageIcon("images/open.png")*/);

        JMenuItem statistic = new JMenuItem("Статистика"/*,
                new ImageIcon("images/open.png")*/);

        // Пункт меню из команды с выходом из программы
        //JMenuItem exit = new JMenuItem(new ExitAction());
        // Добавление к пункту меню изображения
       // exit.setIcon(new ImageIcon("images/exit.png"));
        // Добавим в меню пункта open

        getMenu(0).add(newGame);
        getMenu(0).addSeparator();
        for (JMenuItem jMenuItem : newNameGame) {
            getMenu(0).add(jMenuItem);
           /* getMenu(0).add(starter);
            getMenu(0).add(normal);
            getMenu(0).add(profi);*/
        }
        getMenu(0).add(special);
        getMenu(0).add(statistic);
        // Добавление разделителя
       // file.add(exit);

        setVisible(true);
        newGame.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("ActionListener.actionPerformed : open");
                controller.newGame();
            }
        });


        special.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("ActionListener.actionPerformed : open");
                controller.getOpenSpecialSettings();
            }
        });
     /*   starter.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("ActionListener.actionPerformed : open");
                controller.newGame(controller.getDefaultConfiguration().);
            }
        });

        normal.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("ActionListener.actionPerformed : open");
                controller.newGame(16, 16, 40);
            }
        });

        profi.addActionListener(arg0 -> {
            System.out.println ("ActionListener.actionPerformed : open");
            controller.newGame(16, 30, 99);
        });*/

        statistic.addActionListener(arg0 ->{
            System.out.println("statics");
            //statisticController = new StatisticController();
            controller.getStatisticController().openWindow(0);
        });

       // return file;



    }
}

package view;

import model.Statistic;
import model.StringRecord;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PanelTable extends JPanel {

    private String name;
    private JTable table;

    public PanelTable(String name, Statistic statistic) {
        this.name = name;
        List<StringRecord> recordList = new ArrayList<>();
        //this.table = new JTable();

        Object[] headers = { "Name", "Surname", "Telephone" };

        //statistic.getLists().get(0)
        //Массив содержащий информацию для таблицы
        Object[][] data = {
                { "John", "Smith", "1112221" },
                { "Ivan", "Black", "2221111" },
                { "George", "White", "3334444" },
                { "Bolvan", "Black", "2235111" },
                { "Serg", "Black", "2221511" },
                { "Pussy", "Black", "2221111" },
                { "Tonya", "Red", "2121111" },
                { "Elise", "Green", "2321111" },
        };
        this.table = new JTable(data, headers);
        add(table);
    }


}

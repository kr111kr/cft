package ru.nsu.popova.view;

import ru.nsu.popova.objects.Table;
import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ViewTable {

    public void printTable(Table table)
    {
        int tableSize = table.getTableSize();
        int lenMaxValue = table.getLenMaxValue();

        String designStringSeparator = StringUtils.join(fillListStringDesign(tableSize, lenMaxValue),"+");

        printString(tableSize,lenMaxValue,null, designStringSeparator);

        for (int j = 1; j <= tableSize; ++j) {
            printString(tableSize, lenMaxValue, j, designStringSeparator);
        }
    }

    private void printString(int tableSize, int lenMaxValue, Integer numberString, String designStringSerarator)
    {
        List<String> stringValueList = new ArrayList<>();
        stringValueList.add(buildCell(numberString, ((Integer)tableSize).toString().length()));

        numberString = (numberString == null ? 1 : numberString);

        for (int i = 1; i <= tableSize; ++i) {
            stringValueList.add(buildCell(i * numberString, lenMaxValue));
        }
        System.out.print(StringUtils.join(stringValueList, "|") + "\n" + designStringSerarator + "\n");
    }

    private List<String> fillListStringDesign(Integer tableSize, int lenMaxValue) {
        ArrayList<String> stringDesignList = new ArrayList<>();
        String designOneColumn = normLengthStringFromSymbols("", "-", tableSize.toString().length());;

        stringDesignList.add(designOneColumn);

        String designColumn = normLengthStringFromSymbols("", "-", lenMaxValue);
        for (int i = 1; i <= tableSize; ++i) {
            stringDesignList.add(designColumn);
        }
        return stringDesignList;
    }

    private String buildCell(Integer value, int indent) {

        String valueStr = "";
        if (value != null) {
            valueStr = valueStr.concat(value.toString());
        }

        valueStr = normLengthStringFromSymbols(valueStr, " ", indent);

        return valueStr;
    }

    private  String normLengthStringFromSymbols(String startString, String symbol, int finishLength)
    {
        StringBuilder stringBuilder = new StringBuilder(startString);
        for (int i = startString.length(); i < finishLength; ++i) {
            stringBuilder.insert(0, symbol);
        }
        return stringBuilder.toString();
    }
}

package ru.nsu.popova.model.scanner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ScannerString {

    static public String scannerOneString()
    {
        Scanner scan = new Scanner(System.in);
        String s =  "";
        if (scan.hasNext())
        {
            s = scan.nextLine().toUpperCase();
        }

        return s;
    }

    static public ArrayList<String> scannerString()
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> stringArrayList = new ArrayList<>();

        try {
            if (scan.hasNext())
            {
                stringArrayList.add(scan.nextLine());//.toUpperCase();
            }
           // System.out.println(radius + "  cc");
        } catch (Exception e) {
            throw new IllegalArgumentException("Вы ввели не число!");
        }

        return stringArrayList;
    }

}

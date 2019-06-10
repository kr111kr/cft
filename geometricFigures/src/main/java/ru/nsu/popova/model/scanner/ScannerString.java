package ru.nsu.popova.model.scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScannerString {

    static public FileReader openFileReader() throws FileNotFoundException {

        File file = new File("./src/main/resources/input.txt");
        return new FileReader(file);
    }

    static public List<String> scannerFile(FileReader inputFile) throws IOException {
        List<String> lineFromFile = new ArrayList<>();
        BufferedReader reader = new BufferedReader(inputFile);

        String temp = reader.readLine();

        if (temp == null) {
            throw new IOException("Отсутствуют данные в файле");
        }
        lineFromFile.add(temp.toUpperCase());

        temp = reader.readLine();
        if (temp == null) {
            throw new IOException("Отсутствуют данные в файле");
        }
        lineFromFile.add(temp);

        inputFile.close();

        return lineFromFile;
    }
}

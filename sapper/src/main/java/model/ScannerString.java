package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScannerString {

    static public FileReader openFileReader(String path) throws FileNotFoundException {
        File file = new File(path);
        return new FileReader(file);
    }

    static public List<String> scannerFile(FileReader inputFile) throws IOException {
        List<String> lineFromFile = new ArrayList<>();
        BufferedReader reader = new BufferedReader(inputFile);

        String temp = reader.readLine();

        while (temp != null){
            lineFromFile.add(temp);
            temp = reader.readLine();
        }

        if (lineFromFile.size() == 0) {
            throw new IOException("Отсутствуют данные в файле");
        }

        inputFile.close();

        return lineFromFile;
    }
}

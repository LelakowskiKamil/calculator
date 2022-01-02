package com.lelakowski.calculator.file;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileServiceImpl implements FileService{

    public BufferedReader createBufferedReader(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        return new BufferedReader(fileReader);
    }
    public List<String> loadDataFromBufferedReader(BufferedReader br) throws IOException {
        List<String> operations = new LinkedList<>();
        String line;
        while ((line = br.readLine()) != null) {
            operations.add(line);
        }
        return operations;
    }
}

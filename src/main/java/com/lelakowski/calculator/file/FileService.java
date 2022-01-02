package com.lelakowski.calculator.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileService {
    BufferedReader createBufferedReader(String filePath) throws FileNotFoundException;
    List<String> loadDataFromBufferedReader(BufferedReader br) throws IOException;
}

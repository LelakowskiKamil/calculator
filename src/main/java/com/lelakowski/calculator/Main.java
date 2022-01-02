package com.lelakowski.calculator;

import com.lelakowski.calculator.engine.CalculatorEngine;
import com.lelakowski.calculator.engine.CalculatorEngineImpl;
import com.lelakowski.calculator.file.FileService;
import com.lelakowski.calculator.file.FileServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, please enter the path to the command file");
        String path = scanner.next();
        FileService fileService = new FileServiceImpl();

        try (BufferedReader br = fileService.createBufferedReader(path)){
            List<String> operations = fileService.loadDataFromBufferedReader(br);

            CalculatorEngine calculatorEngine = new CalculatorEngineImpl();
            BigDecimal calculatedValue = calculatorEngine.calculate(operations);
            System.out.println("Result: " + calculatedValue);
        } catch (IOException ex){
            System.out.println("IOException: "+ ex.getMessage());
        }


    }


}
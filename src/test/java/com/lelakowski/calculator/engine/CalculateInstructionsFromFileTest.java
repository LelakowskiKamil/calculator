package com.lelakowski.calculator.engine;

import com.lelakowski.calculator.exception.InvalidArithmeticMarkException;
import com.lelakowski.calculator.exception.InvalidCommandParametersException;
import com.lelakowski.calculator.exception.NotFoundApplyMarkException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


class CalculateInstructionsFromFileTest {

    CalculatorEngine calculatorEngine = new CalculatorEngineImpl();

    @Test
    @DisplayName("CalculatorEngine.calculate() for valid input should return value - short commands list")
    void test1() {
        List<String> operationsList = Arrays.asList("add 2","multiply 3","apply 10");
        BigDecimal expectedResult = new BigDecimal("36");
        Assertions.assertEquals(calculatorEngine.calculate(operationsList), expectedResult);
    }
    @Test
    @DisplayName("CalculatorEngine.calculate() for valid input should return value - long commands list")
    void test2() {
        List<String> operationsList = Arrays.asList("add 2","multiply 3", "divide 5", "subtract 1","apply 1");
        BigDecimal expectedResult = new BigDecimal("0.800000000");
        Assertions.assertEquals(calculatorEngine.calculate(operationsList), expectedResult);
    }
    @Test
    @DisplayName("CalculatorEngine.calculate() for valid input should return value - big precision")
    void test3() {
        List<String> operationsList = Arrays.asList("add 2","multiply 3","divide 7","apply 1");
        BigDecimal expectedResult = new BigDecimal("1.285714286");
        Assertions.assertEquals(calculatorEngine.calculate(operationsList), expectedResult);
    }
    @Test
    @DisplayName("CalculatorEngine.calculate() for valid input should return value - only apply command")
    void test4() {
        List<String> operationsList = List.of("apply 1");
        BigDecimal expectedResult = new BigDecimal("1");
        Assertions.assertEquals(calculatorEngine.calculate(operationsList), expectedResult);
    }
    @Test
    @DisplayName("CalculatorEngine.calculate() for input without 'apply' last operation mark)")
    void test5() {
        List<String> operationsList = Arrays.asList("add 2","multiply 3");
        Assertions.assertThrows(NotFoundApplyMarkException.class, () -> calculatorEngine.calculate(operationsList));
    }
    @Test
    @DisplayName("CalculatorEngine.calculate() for input with unsupported arithmetic operator")
    void test6() {
        List<String> operationsList = Arrays.asList("add 2","power 4", "apply 10");
        Assertions.assertThrows(InvalidArithmeticMarkException.class, () -> calculatorEngine.calculate(operationsList));
    }
    @Test
    @DisplayName("CalculatorEngine.calculate() for input with no value in one command operation")
    void test7() {
        List<String> operationsList = Arrays.asList("add", "apply 10");
        Assertions.assertThrows(InvalidCommandParametersException.class, () -> calculatorEngine.calculate(operationsList));
    }
    @Test
    @DisplayName("CalculatorEngine.calculate() for input when command value is not number format")
    void test8() {
        List<String> operationsList = Arrays.asList("add X", "apply 10");
        Assertions.assertThrows(NumberFormatException.class, () -> calculatorEngine.calculate(operationsList));
    }

    @Test
    @DisplayName("CalculatorEngine.calculate() for input when command have incorrect number of parameters")
    void test9() {
        List<String> operationsList = Arrays.asList("add 5 multiply", "apply 10");
        Assertions.assertThrows(InvalidCommandParametersException.class, () -> calculatorEngine.calculate(operationsList));
    }
}
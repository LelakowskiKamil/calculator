package com.lelakowski.calculator.engine;

import com.lelakowski.calculator.exception.InvalidArithmeticMarkException;
import com.lelakowski.calculator.exception.InvalidCommandParametersException;
import com.lelakowski.calculator.exception.NotFoundApplyMarkException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static com.lelakowski.calculator.math.Operation.*;

public class CalculatorEngineImpl implements CalculatorEngine {

    private String[] splitCommand(String command) {
        String[] operationValuePair = command.split(" ");
        if (operationValuePair.length!=2) {
            throw new InvalidCommandParametersException(command);
        }
        return operationValuePair;
    }

    private BigDecimal performArithmeticOperations(List<String> commands, BigDecimal actualValue) {
        if (commands.size() == 0) {
            return actualValue;
        }
        else {
            String firstCommand = commands.get(0);
            String[] operationValuePair = splitCommand(firstCommand);

            List<String> commandsWithoutFirst = commands.subList(1, commands.size());

            BigDecimal operationValue = new BigDecimal(operationValuePair[1]);
            String operationSymbol = operationValuePair[0];

            if (operationSymbol.equalsIgnoreCase(String.valueOf(ADD))) {
                return performArithmeticOperations(commandsWithoutFirst, actualValue.add(operationValue));
            } else if (operationSymbol.equalsIgnoreCase(String.valueOf(DIVIDE))) {
                return performArithmeticOperations(
                        commandsWithoutFirst,
                        actualValue.divide(operationValue, 9, RoundingMode.HALF_UP)
                );
            } else if (operationSymbol.equalsIgnoreCase(String.valueOf(SUBTRACT))) {
                return performArithmeticOperations(commandsWithoutFirst, actualValue.subtract(operationValue));
            } else if (operationSymbol.equalsIgnoreCase(String.valueOf(MULTIPLY))) {
                return performArithmeticOperations(commandsWithoutFirst, actualValue.multiply(operationValue));
            } else {
                throw new InvalidArithmeticMarkException(operationSymbol);
            }
        }
    }

    private BigDecimal getApplyValue(List<String> allCommands) {
        String applyCommand = allCommands.get(allCommands.size() - 1);
        String[] operationValuePair = splitCommand(applyCommand);
        if (!operationValuePair[0].equalsIgnoreCase(String.valueOf(APPLY))){
            throw new NotFoundApplyMarkException(operationValuePair[0]);
        }
        return new BigDecimal(operationValuePair[1]);
    }

    public BigDecimal calculate(List<String> commands) {
        if (commands.size() == 1) {
            return getApplyValue(commands);
        } else {
            BigDecimal firstValue = getApplyValue(commands);
            int commandsCount = commands.size();
            List<String> commandsWithoutApply = commands.subList(0, commandsCount - 1);
            return performArithmeticOperations(commandsWithoutApply, firstValue);
        }
    }
}

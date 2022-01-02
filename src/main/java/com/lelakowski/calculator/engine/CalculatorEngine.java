package com.lelakowski.calculator.engine;

import java.math.BigDecimal;
import java.util.List;

public interface CalculatorEngine {

    BigDecimal calculate(List<String> operations);
}

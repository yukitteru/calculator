package net.yukitteru.calculator.util;

import net.yukitteru.calculator.enumeration.Notation;
import net.yukitteru.calculator.exception.IllegalExpressionException;
import net.yukitteru.calculator.operand.Operand;
import net.yukitteru.calculator.operand.impl.IntegerOperand;
import net.yukitteru.calculator.operation.impl.Addition;
import net.yukitteru.calculator.operation.impl.Division;
import net.yukitteru.calculator.operation.impl.Multiplication;
import net.yukitteru.calculator.operation.impl.Subtraction;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

public class ReversePolishNotation {

    public Integer eval(final String[] notation) {
        var arithmeticOperations = Map.of(
                "/", new Division(),
                "*", new Multiplication(),
                "+", new Addition(),
                "-", new Subtraction()
        );

        var operands = new LinkedList<Operand<Integer>>();
        Arrays.stream(notation).forEach(token -> {
            if (isRomeNumber(token)) {
                int i = NumerationConverter.romanToArabic(token);
                if (i > 10 || i < 1) try {
                    throw new IllegalExpressionException("The application only works with integers from I to X");
                } catch (IllegalExpressionException e) {
                    e.printStackTrace();
                } else {
                    operands.push(new IntegerOperand(i));
                }

            } else if (isArabicNumber(token)) {
                if (Integer.parseInt(token) > 10 || Integer.parseInt(token) < 1)
                    try {
                        throw new IllegalExpressionException("The application only works with integers from 1 to 10");
                    } catch (IllegalExpressionException e) {

                    }
                else {
                    operands.push(new IntegerOperand(token));
                }

            } else {
                var b = operands.pop();
                var a = operands.pop();
                operands.push(new IntegerOperand(arithmeticOperations.get(token).eval(a, b)));
            }
        });
        return operands.pop().get();
    }

    private boolean isRomeNumber(String token) {
        if (token.equals("-")) return false;
        return token.codePoints()
                .filter(c -> c != '-')
                .mapToObj(operand -> (char) operand)
                .allMatch(value -> Notation.isValidRoman(String.valueOf(value)));
    }

    private boolean isArabicNumber(String token) {
        if (token.equals("-")) return false;
        return token.codePoints().filter(c -> c != '-').allMatch(Character::isDigit);

    }

}

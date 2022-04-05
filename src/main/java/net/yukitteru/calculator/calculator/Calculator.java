package net.yukitteru.calculator.calculator;

import lombok.RequiredArgsConstructor;
import net.yukitteru.calculator.exception.IllegalExpressionException;
import net.yukitteru.calculator.util.InfixToPostfixConverter;
import net.yukitteru.calculator.util.NumerationConverter;
import net.yukitteru.calculator.util.ReversePolishNotation;

@RequiredArgsConstructor
public class Calculator {
    private final InfixToPostfixConverter infixToPostfixConverter;
    private final ReversePolishNotation reversePolishNotation;


    public Object calculate(String infixExpression) throws IllegalExpressionException {
        String postfix = infixToPostfixConverter.convert(infixExpression);
        Integer eval = reversePolishNotation.eval(postfix.split(" "));

        try {
            if (postfix.chars().anyMatch(Character::isDigit)) {
                return reversePolishNotation.eval(postfix.split(" "));
            } else {
                return NumerationConverter.arabicToRoman(eval);
            }
        } catch (Exception e) {
            throw new IllegalExpressionException("The application only works with integers");
        }

    }
}

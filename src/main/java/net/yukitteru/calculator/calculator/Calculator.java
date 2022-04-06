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


    public Object calculate(String infixExpression) throws IllegalExpressionException, IncorrectResultValueException {
        String postfix = infixToPostfixConverter.convert(infixExpression);
        Integer eval = reversePolishNotation.eval(postfix.split(" "));
        try {
            if (postfix.chars().anyMatch(Character::isDigit)) {
                return eval;
            } else {
                return NumerationConverter.arabicToRoman(eval);
            }
        } catch (Exception e) {
            if (eval < 1) {
                throw new IncorrectResultValueException("Roman numerals cannot be less than 1");
            } else throw new IllegalExpressionException("The based expression is not valid. Try again");
        }

    }
}

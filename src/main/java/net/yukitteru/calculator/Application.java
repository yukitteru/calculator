package net.yukitteru.calculator;

import net.yukitteru.calculator.calculator.Calculator;
import net.yukitteru.calculator.exception.IllegalExpressionException;
import net.yukitteru.calculator.util.ExpressionParser;
import net.yukitteru.calculator.util.InfixToPostfixConverter;
import net.yukitteru.calculator.util.ReversePolishNotation;

public class Application {
    public static void main(String[] args) throws IllegalExpressionException {
        String infixExpression = "V * V";

        ExpressionParser.isValidExpr(infixExpression);

        var expressionParser = new ExpressionParser();
        var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
        var reversePolishNotation = new ReversePolishNotation();

        var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
        Object result = calculator.calculate(infixExpression);
        System.out.println(result);

    }

}

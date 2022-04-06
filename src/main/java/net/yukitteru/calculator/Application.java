package net.yukitteru.calculator;

import net.yukitteru.calculator.calculator.Calculator;
import net.yukitteru.calculator.exception.IllegalExpressionException;
import net.yukitteru.calculator.exception.IncorrectResultValueException;
import net.yukitteru.calculator.util.ExpressionParser;
import net.yukitteru.calculator.util.InfixToPostfixConverter;
import net.yukitteru.calculator.util.ReversePolishNotation;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IllegalExpressionException, IncorrectResultValueException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a mathematical expression: ");
        String infixExpression = scanner.nextLine();

        if (ExpressionParser.isValidExpr(infixExpression)) {
            var expressionParser = new ExpressionParser();
            var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
            var reversePolishNotation = new ReversePolishNotation();

            var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
            Object result = calculator.calculate(infixExpression);
            System.out.println("Your result is: " + result);
        } else throw new IllegalExpressionException("The based expression is not valid. Try again");

    }

}

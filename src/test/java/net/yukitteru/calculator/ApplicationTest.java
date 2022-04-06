package net.yukitteru.calculator;

import net.yukitteru.calculator.calculator.Calculator;
import net.yukitteru.calculator.exception.IllegalExpressionException;
import net.yukitteru.calculator.exception.IncorrectResultValueException;
import net.yukitteru.calculator.util.ExpressionParser;
import net.yukitteru.calculator.util.InfixToPostfixConverter;
import net.yukitteru.calculator.util.ReversePolishNotation;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {
    @Test
    public void itShouldEvaluateTheGivenExpressionWithArabicNumbersAdditionalOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "5 + 8";
        if (ExpressionParser.isValidExpr(infixExpression)) {
            var expressionParser = new ExpressionParser();
            var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
            var reversePolishNotation = new ReversePolishNotation();

            var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
            Object result = calculator.calculate(infixExpression);
            assertEquals(13, result);
        } else throw new IllegalExpressionException("The based expression is not valid. Try again");
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithArabicNumbersSubtractionOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "10 - 6";
        if (ExpressionParser.isValidExpr(infixExpression)) {
            var expressionParser = new ExpressionParser();
            var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
            var reversePolishNotation = new ReversePolishNotation();

            var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
            Object result = calculator.calculate(infixExpression);
            assertEquals(4, result);
        } else throw new IllegalExpressionException("The based expression is not valid. Try again");
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithArabicNumbersMultiplicationOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "9 * 7";
        if (ExpressionParser.isValidExpr(infixExpression)) {
            var expressionParser = new ExpressionParser();
            var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
            var reversePolishNotation = new ReversePolishNotation();

            var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
            Object result = calculator.calculate(infixExpression);
            assertEquals(63, result);
        } else throw new IllegalExpressionException("The based expression is not valid. Try again");
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithArabicNumbersDivisionOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "8 / 4";
        if (ExpressionParser.isValidExpr(infixExpression)) {
            var expressionParser = new ExpressionParser();
            var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
            var reversePolishNotation = new ReversePolishNotation();

            var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
            Object result = calculator.calculate(infixExpression);
            assertEquals(2, result);
        } else throw new IllegalExpressionException("The based expression is not valid. Try again");
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithRomeNumbersPlusOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "IV + IX";
        if (ExpressionParser.isValidExpr(infixExpression)) {
            var expressionParser = new ExpressionParser();
            var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
            var reversePolishNotation = new ReversePolishNotation();

            var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
            Object result = calculator.calculate(infixExpression);
            assertEquals("XIII", result);
        } else throw new IllegalExpressionException("The based expression is not valid. Try again");
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithRomeNumbersSubtractionOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "IX - III";
        if (ExpressionParser.isValidExpr(infixExpression)) {
            var expressionParser = new ExpressionParser();
            var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
            var reversePolishNotation = new ReversePolishNotation();

            var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
            Object result = calculator.calculate(infixExpression);
            assertEquals("VI", result);
        } else throw new IllegalExpressionException("The based expression is not valid. Try again");
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithRomeNumbersMultiplicationOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "III * VII";
        if (ExpressionParser.isValidExpr(infixExpression)) {
            var expressionParser = new ExpressionParser();
            var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
            var reversePolishNotation = new ReversePolishNotation();

            var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
            Object result = calculator.calculate(infixExpression);
            assertEquals("XXI", result);
        } else throw new IllegalExpressionException("The based expression is not valid. Try again");
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithRomeNumbersDivisionOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "X / II";
        if (ExpressionParser.isValidExpr(infixExpression)) {
            var expressionParser = new ExpressionParser();
            var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
            var reversePolishNotation = new ReversePolishNotation();

            var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
            Object result = calculator.calculate(infixExpression);
            assertEquals("V", result);
        } else throw new IllegalExpressionException("The based expression is not valid. Try again");
    }

    @Test(expected = IncorrectResultValueException.class)
    public void itShouldEvaluateTheGivenExpressionWithRomeNumbersWithNegativeNumbersAndReturnTheResult() throws IncorrectResultValueException, IllegalExpressionException {
        String infixExpression = "V - VI";
        if (ExpressionParser.isValidExpr(infixExpression)) {
            var expressionParser = new ExpressionParser();
            var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
            var reversePolishNotation = new ReversePolishNotation();

            var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
            Object result = calculator.calculate(infixExpression);
            System.out.println("Your result is: " + result);
        } else throw new IllegalExpressionException("The based expression is not valid. Try again");
    }

    @Test(expected = NoSuchElementException.class)
    public void itShouldEvaluateTheGivenExpressionWithRomeNumbersWithANumberGreaterThenTensAndReturnTheResult() throws IncorrectResultValueException, IllegalExpressionException {
        String infixExpression = "C + I";
        if (ExpressionParser.isValidExpr(infixExpression)) {
            var expressionParser = new ExpressionParser();
            var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
            var reversePolishNotation = new ReversePolishNotation();

            var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
            Object result = calculator.calculate(infixExpression);
            System.out.println("Your result is: " + result);
        } else throw new IllegalExpressionException("The based expression is not valid. Try again");
    }

    @Test(expected = IllegalExpressionException.class)
    public void itShouldEvaluateTheGivenExpressionWithRomeNumbersWithArabicNumbersAndReturnTheResult() throws IncorrectResultValueException, IllegalExpressionException {
        String infixExpression = "V + 7";
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

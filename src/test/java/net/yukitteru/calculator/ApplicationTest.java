package net.yukitteru.calculator;

import net.yukitteru.calculator.calculator.Calculator;
import net.yukitteru.calculator.exception.IllegalExpressionException;
import net.yukitteru.calculator.util.ExpressionParser;
import net.yukitteru.calculator.util.InfixToPostfixConverter;
import net.yukitteru.calculator.util.ReversePolishNotation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationTest {
    @Test
    public void itShouldEvaluateTheGivenExpressionWithArabicNumbersAdditionalOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "5 + 8";
        var expressionParser  = new ExpressionParser();
        var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
        var reversePolishNotation = new ReversePolishNotation();

        var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
        var result = calculator.calculate(infixExpression);
        assertEquals(13, result);
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithArabicNumbersSubtractionOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "10 - 6";
        var expressionParser  = new ExpressionParser();
        var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
        var reversePolishNotation = new ReversePolishNotation();

        var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
        var result = calculator.calculate(infixExpression);
        assertEquals(4, result);
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithArabicNumbersMultiplicationOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "9 * 7";
        var expressionParser  = new ExpressionParser();
        var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
        var reversePolishNotation = new ReversePolishNotation();

        var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
        var result = calculator.calculate(infixExpression);
        assertEquals(63, result);
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithArabicNumbersDivisionOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "8 / 4";
        var expressionParser  = new ExpressionParser();
        var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
        var reversePolishNotation = new ReversePolishNotation();

        var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
        var result = calculator.calculate(infixExpression);
        assertEquals(2, result);
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithRomeNumbersPlusOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "IV + IX";
        var expressionParser  = new ExpressionParser();
        var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
        var reversePolishNotation = new ReversePolishNotation();

        var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
        var result = calculator.calculate(infixExpression);
        assertEquals("XIII", result);
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithRomeNumbersSubtractionOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "IX - III";
        var expressionParser  = new ExpressionParser();
        var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
        var reversePolishNotation = new ReversePolishNotation();

        var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
        var result = calculator.calculate(infixExpression);
        assertEquals("VI", result);
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithRomeNumbersMultiplicationOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "III * VII";
        var expressionParser  = new ExpressionParser();
        var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
        var reversePolishNotation = new ReversePolishNotation();

        var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
        var result = calculator.calculate(infixExpression);
        assertEquals("XXI", result);
    }

    @Test
    public void itShouldEvaluateTheGivenExpressionWithRomeNumbersDivisionOperationAndReturnTheResult() throws IllegalExpressionException, IncorrectResultValueException {
        String infixExpression = "X / II";
        var expressionParser  = new ExpressionParser();
        var infixToPostfixConverter = new InfixToPostfixConverter(expressionParser);
        var reversePolishNotation = new ReversePolishNotation();

        var calculator = new Calculator(infixToPostfixConverter, reversePolishNotation);
        var result = calculator.calculate(infixExpression);
        assertEquals("V", result);
    }
}

package net.yukitteru.calculator.util;

import net.yukitteru.calculator.operation.GroupingOperator;
import net.yukitteru.calculator.operation.Operator;
import net.yukitteru.calculator.operation.impl.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InfixToPostfixConverter {
    private static final Map<String, Operator> OPERATORS = Map.of(
            "/", new Division(),
            "*", new Multiplication(),
            "+", new Addition(),
            "-", new Subtraction()
    );

    private static final Map<String, GroupingOperator> GROUPING_OPERATORS = Map.of(
            "(", new OpenParenthesis(),
            ")", new CloseParenthesis()
    );

    public static final String SPACE = " ";

    public ExpressionParser expressionParser;


    public InfixToPostfixConverter(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
    }

    public String convert(String infixExpression) {
        List<String> tokens = expressionParser.parseInFix(infixExpression);
        StringBuilder out = new StringBuilder();
        LinkedList<Operator> stack = new LinkedList<>();
        for (String token : tokens) {
            if (OPERATORS.containsKey(token)) {
                Operator curr = OPERATORS.get(token);
                while (!stack.isEmpty() && less(curr, stack.peekFirst()))
                    out.append(stack.pop()).append(SPACE);

                stack.push(curr);
            } else if (GROUPING_OPERATORS.containsKey(token)) {
                GroupingOperator currOp = GROUPING_OPERATORS.get(token);
                if (currOp instanceof OpenParenthesis)
                    stack.push(currOp);
                else if (currOp instanceof CloseParenthesis) {
                    Operator curr;
                    while (!((curr = stack.pop()) instanceof OpenParenthesis))
                        out.append(curr).append(SPACE);
                }
            } else out.append(token).append(SPACE);
        }

        while (!stack.isEmpty())
            out.append(stack.pop()).append(SPACE);
        return out.toString().trim();
    }

    private boolean less(Operator op1, Operator op2) {
        return op1.precedence().compareTo(op2.precedence()) <= 0;
    }

}

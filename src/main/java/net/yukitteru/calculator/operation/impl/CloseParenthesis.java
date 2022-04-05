package net.yukitteru.calculator.operation.impl;

import net.yukitteru.calculator.operation.GroupingOperator;
import net.yukitteru.calculator.operation.Operator;

public class CloseParenthesis implements GroupingOperator {
    @Override
    public Integer precedence() {
        return 3;
    }

    @Override
    public String association() {
        return "12r";
    }

    @Override
    public String toString() {
        return ")";
    }
}

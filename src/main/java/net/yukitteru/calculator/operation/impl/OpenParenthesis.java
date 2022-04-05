package net.yukitteru.calculator.operation.impl;

import net.yukitteru.calculator.operation.GroupingOperator;

public class OpenParenthesis implements GroupingOperator {
    @Override
    public Integer precedence() {
        return -1;
    }

    @Override
    public String association() {
        return null;
    }

    @Override
    public String toString() {
        return "(";
    }
}

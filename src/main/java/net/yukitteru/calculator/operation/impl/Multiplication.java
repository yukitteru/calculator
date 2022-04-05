package net.yukitteru.calculator.operation.impl;

import net.yukitteru.calculator.operand.Operand;
import net.yukitteru.calculator.operation.ArithmeticOperator;

public class Multiplication implements ArithmeticOperator {

    @Override
    public Integer precedence() {
        return 2;
    }

    @Override
    public String association() {
        return null;
    }

    @Override
    public Integer eval(Operand<Integer> a, Operand<Integer> b) {
        return a.get() * b.get();
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}

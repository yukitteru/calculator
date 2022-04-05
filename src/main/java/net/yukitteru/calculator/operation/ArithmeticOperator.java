package net.yukitteru.calculator.operation;

import net.yukitteru.calculator.operand.Operand;

public interface ArithmeticOperator extends Operator {

    Integer eval(Operand<Integer> a, Operand<Integer> b);
}

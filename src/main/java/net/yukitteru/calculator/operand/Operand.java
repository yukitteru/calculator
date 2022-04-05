package net.yukitteru.calculator.operand;

public interface Operand<T extends Comparable<T>> {
    T get();
}

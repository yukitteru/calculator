package net.yukitteru.calculator.operation;

public interface Operator {

    Integer precedence();
    String association();
}

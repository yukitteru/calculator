package net.yukitteru.calculator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExpressionParser {
    private static final Set<Character> operators = Set.of(
            '(',
            ')',
            '/',
            '*',
            '+',
            '-'
    );


    public static boolean isValidExpr(String expr) {
        if (expr.chars().filter(c -> c != '+' && c != '-' && c != '*' && c != '/').allMatch(Character::isDigit)) {
            return true;
        }
        if (expr.chars().filter(c -> c != '+' && c != '-' && c != '*' && c != '/').allMatch(Character::isAlphabetic)) {
            return true;
        }
        return false;
    }


    public List<String> parseInFix(String expr) {
        expr = expr.replaceAll("\\s", "");
        List<String> out = new ArrayList<>();
        int pivot = 0;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (operators.contains(c)) {
                final String token = expr.substring(pivot, i);
                if (!token.isEmpty())
                    out.add(token);

                pivot = i + 1;
                out.add(String.valueOf(c));
            }
        }

        if (pivot < expr.length())
            out.add(expr.substring(pivot));

        return out;
    }
}

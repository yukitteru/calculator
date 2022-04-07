package net.yukitteru.calculator.enumeration;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Notation {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private final int val;

    Notation(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public static boolean isValidRoman(String token) {
        String regex = "(?<=^)M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})(?=$)";
        boolean matches = token.matches(regex);
        if (!matches) throw new NoSuchElementException("Incorrect Roman number");
        return true;
    }

    public static boolean isValidArabic(String token) {
        if (token.equals("-")) return false;
        boolean b = token.chars().filter(c -> c != '-').allMatch(Character::isDigit);
        if (!b) throw new NoSuchElementException("Incorrect Arabic number");
        return true;
    }


    public static List<Notation> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((Notation e) -> e.val).reversed())
                .collect(Collectors.toList());
    }

}

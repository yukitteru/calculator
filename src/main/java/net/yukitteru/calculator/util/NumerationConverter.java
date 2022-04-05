package net.yukitteru.calculator.util;

import net.yukitteru.calculator.enumeration.Notation;

import java.util.List;

public class NumerationConverter {

    public static int romanToArabic(String input) {
        String romanNumeral = input.toUpperCase();
        int result = 0;

        List<Notation> romanNumerals = Notation.getReverseSortedValues();

        int i = 0;

        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            Notation symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getVal();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<Notation> romanNumerals = Notation.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            Notation currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getVal() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getVal();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}

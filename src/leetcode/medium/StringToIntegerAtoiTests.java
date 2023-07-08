package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


// @see https://leetcode.com/problems/string-to-integer-atoi/
public class StringToIntegerAtoiTests {

    @Test
    public void case1() {
        assertEquals(42, myAtoi("42"));
    }

    @Test
    public void case2() {
        assertEquals(-42, myAtoi("   -42"));
    }

    @Test
    public void case3() {
        assertEquals(4193, myAtoi("4193 with words"));
    }

    @Test
    public void case4() {
        assertEquals(-2147483648, myAtoi("-91283472332"));
    }

    @Test
    public void case5() {
        assertEquals(0, myAtoi("words and 987"));
    }

    @Test
    public void case6() {
        assertEquals(0, myAtoi("-+12"));
    }

    @Test
    public void case7() {
        assertEquals(0, myAtoi("+-12"));
    }

    @Test
    public void case8() {
        assertEquals(0, myAtoi(""));
    }

    @Test
    public void case9() {
        assertEquals(1, myAtoi("+1"));
    }


    public int myAtoi(String s) {
        String ss = s.stripLeading();
        if (ss.isEmpty()) return 0;

        char first = ss.charAt(0);

        boolean notDigit = (first  < '0' || first  > '9');
        boolean notSign  = (first != '-' && first != '+');
        if (notDigit && notSign) return 0;

        boolean negative = ('-' == first);
        boolean signed = (negative || first == '+');

        StringBuilder builder = new StringBuilder();
        for (int i = (signed ? 1 : 0); i < ss.length(); i++) {
            char ch = ss.charAt(i);
            if (ch < '0' || ch > '9') break;

            builder.append(ch);
        }

        if (builder.length() < 1) return 0;

        try {
            return Integer.parseInt((negative ? "-" : "") + builder);
        } catch (NumberFormatException e) {
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}

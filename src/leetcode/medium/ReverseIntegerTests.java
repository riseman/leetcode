package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


// @see https://leetcode.com/problems/reverse-integer/
public class ReverseIntegerTests {

    @Test
    public void case1() {
        assertEquals(321, reverse(123));
    }

    @Test
    public void case2() {
        assertEquals(-321, reverse(-123));
    }

    @Test
    public void case3() {
        assertEquals(21, reverse(120));
    }

    @Test
    public void case4() {
        assertEquals(0, reverse(1534236469));
    }

    @Test
    public void case5() {
        assertEquals(2147483641, reverse(1463847412));
    }

    @Test
    public void case6() {
        assertEquals(0, reverse(2147483647));
    }

    @Test
    public void case7() {
        assertEquals(0, reverse(-1563847412));
    }


    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            try {
                result = Math.multiplyExact(result, 10);
                result = Math.addExact(result, x % 10);
            } catch (ArithmeticException e) {
                return 0;
            }

            x /= 10;
        }

        return result;
    }
}

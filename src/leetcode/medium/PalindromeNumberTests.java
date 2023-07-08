package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


// @see https://leetcode.com/problems/palindrome-number/
public class PalindromeNumberTests {

    @Test
    public void case1() {
        assertTrue(isPalindrome(121));
    }

    @Test
    public void case2() {
        assertFalse(isPalindrome(-121));
    }

    @Test
    public void case3() {
        assertFalse(isPalindrome(10));
    }


    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}

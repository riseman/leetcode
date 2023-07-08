package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;


// @see https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharactersTests {

    @Test
    public void case1() {
        assertEquals(0, lengthOfLongestSubstring(""));
    }

    @Test
    public void case2() {
        assertEquals(1, lengthOfLongestSubstring(" "));
    }

    @Test
    public void case3() {
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    public void case4() {
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void case5() {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void case6() {
        assertEquals(55, lengthOfLongestSubstring("hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
    }


    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                int sym = s.charAt(j);
                if (set.contains(sym)) break;

                set.add(sym);
                max = Math.max(max, set.size());
            }

        }

        return max;
    }
}

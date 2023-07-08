package leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


// @see https://leetcode.com/problems/valid-parentheses/
public class ValidParenthesesTests {

    @Test
    public void case1() {
        assertTrue(isValid("()"));
    }

    @Test
    public void case2() {
        assertTrue(isValid("()[]{}"));
    }

    @Test
    public void case3() {
        assertFalse(isValid("(]"));
    }

    @Test
    public void case4() {
        assertFalse(isValid("(([(]"));
    }

    @Test
    public void case5() {
        assertTrue(isValid("(([]()[]))"));
    }

    @Test
    public void case6() {
        assertTrue(isValid("(())"));
    }

    public boolean isValid(String s) {
        Map<Character, Character> parentheses = Map.of('(', ')', '[', ']', '{', '}');

        Stack<Character> stack = new Stack<>();
        for (Character current: s.toCharArray()) {
            if (parentheses.containsKey(current)) {
                stack.push(current);
                continue;
            }

            if (stack.isEmpty())
                return false;

            Character open = stack.pop();
            Character close = parentheses.get(open);

            if (null != open)
                if (! current.equals(close))
                    return false;
        }

        return stack.empty();
    }
}

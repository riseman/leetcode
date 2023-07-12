package leetcode.medium;

import lombok.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


// @see https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbersTests {

    @Test
    public void case1() {
        assertEquals(
            new ListNode(7, new ListNode(0, new ListNode(8))),
            addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))));
    }

    @Test
    public void case2() {
        assertEquals(
            new ListNode(0),
            addTwoNumbers(
                new ListNode(0),
                new ListNode(0)));
    }

    @Test
    public void case3() {
        assertEquals(
            new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1)))))))),
            addTwoNumbers(
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))),
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, false);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean over) {
        if ((null == l1) && (null == l2))
            return over ? new ListNode(1) : null;

        int val1 = (null != l1) ? l1.val : 0;
        int val2 = (null != l2) ? l2.val : 0;
        int sum = val1 + val2 + (over ? 1 : 0);

        over = false; if (sum > 9) {
            over = true;
            sum = sum % 10;
        }

        return new ListNode(sum, addTwoNumbers((null != l1) ? l1.next : null, (null != l2) ? l2.next : null, over));
    }

    @Data
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

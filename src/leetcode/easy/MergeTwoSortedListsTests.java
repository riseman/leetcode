package leetcode.easy;

import lombok.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


// @see https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedListsTests {

    @Test
    public void case1() {
        assertEquals(
            new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4)))))),
            mergeTwoLists(
                new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))));
    }

    @Test
    public void case2() {
        assertEquals(
            new ListNode(0, new ListNode()),
            mergeTwoLists(
                new ListNode(),
                new ListNode()));
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1) return list2;
        if (null == list2) return list1;

        ListNode list;
        if (list1.val <= list2.val) {
            list = list1;
            list.next = mergeTwoLists(list1.next, list2);
        } else {
            list = list2;
            list.next = mergeTwoLists(list1, list2.next);
        }

        return list;
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

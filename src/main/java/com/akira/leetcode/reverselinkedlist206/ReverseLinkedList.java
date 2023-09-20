package com.akira.leetcode.reverselinkedlist206;

import com.akira.leetcode.common.ListNode;
import com.akira.leetcode.util.ListNodeUtil;
import com.akira.leetcode.util.ListUtil;

public class ReverseLinkedList {
    public static void launch() {
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode head = ListUtil.arrToListNode(new int[] { 1, 2, 3, 4, 5 });
        // ListNode newHead = solution.reverseList(head);
        ListNode newHead = solution.reverseList2(head);
        ListNodeUtil.traversalListNode(newHead);
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // ListNode newHead = reverseList(head.next);
        // head.next.next = head;
        // head.next = null;
        // return newHead;
        return recur(null, head);
    }

    // 1. 递归法
    private ListNode recur(ListNode prev, ListNode curr) {
        if (curr == null) {
            return prev;
        }
        ListNode newHead = recur(curr, curr.next);
        curr.next = prev;
        return newHead;
    }

    // 2. 迭代法
    private ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

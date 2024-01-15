package com.akira.leetcode.removeduplicatesfromsortedlistii82;


import com.akira.leetcode.common.ListNode;
import com.akira.leetcode.util.ListNodeUtil;
import com.akira.leetcode.util.ListUtil;

public class RemoveDuplicatesFromSortedListII {
    public static void launch() {
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();
        ListNode head = ListUtil.arrToListNode(new int[]{1, 1, 2, 3, 4, 4, 5});
        ListNode node = solution.deleteDuplicates(head);
        ListNodeUtil.traversalListNode(node);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}

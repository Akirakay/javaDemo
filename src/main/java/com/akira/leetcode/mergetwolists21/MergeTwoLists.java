package com.akira.leetcode.mergetwolists21;

import com.akira.leetcode.common.ListNode;
import com.akira.leetcode.util.ListUtil;
import com.akira.leetcode.util.ListNodeUtil;

public class MergeTwoLists {
    public static void launch() {
        MergeTwoLists solution = new MergeTwoLists();
        ListNode list1 = ListUtil.arrToListNode(new int[] { 1, 2, 4 });
        ListNode list2 = ListUtil.arrToListNode(new int[] { 1, 3, 4 });
        // ListNode node = solution.mergeTwoLists(list1, list2);
        ListNode node = solution.recurMergeTwoLists(list1, list2);
        ListNodeUtil.traversalListNode(node);
    }

    // 1 迭代法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode head = new ListNode(-1, null);
        ListNode preHead = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                preHead.next = list1;
                list1 = list1.next;
            } else {
                preHead.next = list2;
                list2 = list2.next;
            }
            preHead = preHead.next;
        }
        preHead.next = list1 == null ? list2 : list1;
        return head.next;
    }

    // 2. 递归
    public ListNode recurMergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = recurMergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = recurMergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

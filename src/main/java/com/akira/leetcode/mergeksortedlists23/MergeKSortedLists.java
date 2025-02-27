package com.akira.leetcode.mergeksortedlists23;

import com.akira.leetcode.common.ListNode;
import com.akira.leetcode.util.ListNodeUtil;
import com.akira.leetcode.util.ListUtil;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.mergeksortedlists23
 * @className: MergeKSortedLists
 * @author: tzk
 * @description: TODO
 * @date: 2025/2/27 10:44
 * @version: 1.0
 */
public class MergeKSortedLists {
    public static void launch() {
        MergeKSortedLists solution = new MergeKSortedLists();
        int[][] arr = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        ListNode[] lists = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lists[i] = ListUtil.arrToListNode(arr[i]);
        }
        ListNode listNode = solution.mergeKLists(lists);
        ListNodeUtil.traversalListNode(listNode);
    }

    /**
     * foresee @see {@link com.akira.leetcode.mergetwolists21.MergeTwoLists#mergeTwoLists(com.akira.leetcode.common.ListNode, com.akira.leetcode.common.ListNode) }
     * using divide and conquer
     * @param lists
     * @return com.akira.leetcode.common.ListNode
     * @author Ak1ra
     * @date 2025/2/27 11:02
     * @description
     */
    private ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        } else if (l < r) {
            int mid = (l + r) / 2;
            ListNode left = merge(lists, l, mid);
            ListNode right = merge(lists, mid + 1, r);
            return mergeTwoLists(left, right);
        } else {
            return null;
        }
    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                tail.next = cur1;
                cur1 = cur1.next;
            } else {
                tail.next = cur2;
                cur2 = cur2.next;
            }
            tail = tail.next;
        }
        tail.next = cur1 != null ? cur1 : cur2;
        return dummy.next;
    }

}

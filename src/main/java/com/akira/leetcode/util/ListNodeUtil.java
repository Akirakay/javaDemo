package com.akira.leetcode.util;

import com.akira.leetcode.common.ListNode;

public class ListNodeUtil {
    public static void traversalListNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

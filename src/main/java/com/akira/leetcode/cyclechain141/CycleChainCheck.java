package com.akira.leetcode.cyclechain141;

import java.util.HashSet;
import java.util.Set;

import com.akira.leetcode.common.ListNode;
import com.akira.leetcode.util.ListUtil;

public class CycleChainCheck {
    public static void launch() {
        CycleChainCheck solution = new CycleChainCheck();
        ListNode head = ListUtil.arrToCycleListNode(new int[] { 3, 2, 0, -4 }, 1);
        // boolean flag = solution.hasCycle(head);
        boolean flag = solution.hasCycleWithMap(head);
        System.out.println(flag);
    }

    // 1. 快慢指针法
    public boolean hasCycle(ListNode head) {
        // if (head == null || head.next == null) {
        // return false;
        // }
        // ListNode fast = head;
        // ListNode slow = head;
        // while (fast != null && slow != null) {
        // fast = fast.next.next;
        // slow = slow.next;
        // if (fast == slow) {
        // return true;
        // }
        // }
        // return false;
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    // 2.哈希表
    public boolean hasCycleWithMap(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

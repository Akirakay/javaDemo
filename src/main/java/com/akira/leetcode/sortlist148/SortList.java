package com.akira.leetcode.sortlist148;

import com.akira.leetcode.common.ListNode;
import com.akira.leetcode.util.ListNodeUtil;
import com.akira.leetcode.util.ListUtil;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.sortlist148
 * @className: SortList
 * @author: tzk
 * @description: TODO
 * @date: 2025/2/9 08:46
 * @version: 1.0
 */
public class SortList {
    public static void launch() {
        SortList solution = new SortList();
        ListNode head = ListUtil.arrToListNode(new int[]{4, 2, 1, 3});
        ListNode newHead = solution.sortList(head);
        ListNodeUtil.traversalListNode(newHead);
    }

    /**
     * 归并排序
     * <a href="https://leetcode.cn/problems/sort-list/solutions/492301/pai-xu-lian-biao-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked" />
     * @param head
     * @return com.akira.leetcode.common.ListNode
     * @author Ak1ra
     * @date 2025/2/9 08:52
     * @description
     */
    public ListNode sortList(ListNode head) {
        // 递归终止条件：链表为空或只有一个节点
        if (head == null || head.next == null) {
            return head;
        }

        // 找到链表的中点
        ListNode mid = findMiddle(head);
        ListNode rightHead = mid.next; // 右半部分的头节点
        mid.next = null; // 断开链表

        // 递归排序左半部分和右半部分
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 合并两个有序链表
        return mergeTwoLists(left, right);
    }

    // 找到链表的中点（快慢指针法）
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // fast 从 head.next 开始，确保 slow 指向中点或左中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个有序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); // 虚拟头节点
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        // 将剩余的链表接上
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }
}

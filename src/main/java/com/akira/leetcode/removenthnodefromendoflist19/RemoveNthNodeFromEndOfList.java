package com.akira.leetcode.removenthnodefromendoflist19;


import com.akira.leetcode.common.ListNode;
import com.akira.leetcode.util.ListNodeUtil;
import com.akira.leetcode.util.ListUtil;

public class RemoveNthNodeFromEndOfList {
    public static void launch() {
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        ListNode node = ListUtil.arrToListNode(new int[] { 1, 2 });
//        ListNode head = solution.removeNthFromEnd(node, 2);
        ListNode head = solution.removeNthFromEnd2(node, 2);
        ListNodeUtil.traversalListNode(head);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head != null) {
            ListNode fastNode = head;
            ListNode slowNode = head;
            ListNode preNode = null;
            for (int i = 0; i < n; i++) {
                fastNode = fastNode.next;
            }
            while (fastNode != null) {
                fastNode = fastNode.next;
                preNode = slowNode;
                slowNode = slowNode.next;
            }
            // 删除的是头结点
            if (slowNode == head) {
                return head.next;
            }
            // 其他情况
            if (preNode != null) {
                preNode.next = preNode.next.next;
            }
            return head;
        }
        return null;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 虚拟节点
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}

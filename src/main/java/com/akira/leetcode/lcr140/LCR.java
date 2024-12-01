package com.akira.leetcode.lcr140;


import com.akira.leetcode.common.ListNode;
import com.akira.leetcode.util.ListUtil;

public class LCR {
    public static void launch() {
        LCR solution = new LCR();
        ListNode head = ListUtil.arrToListNode(new int[]{2, 4, 7, 8});
        ListNode node = solution.trainingPlan(head, 1);
        System.out.println(node.val);
    }

    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode former = head, latter = head;
        // 快慢指针 让快指针先走cnt步
        for (int i = 0; i < cnt; i++)
            former = former.next;
        // 一起移动 快指针停止的时候慢指针停在倒数第cnt个节点
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}

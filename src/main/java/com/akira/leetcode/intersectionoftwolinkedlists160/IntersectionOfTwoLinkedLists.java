package com.akira.leetcode.intersectionoftwolinkedlists160;


import com.akira.leetcode.common.ListNode;
import com.akira.leetcode.util.ListUtil;

public class IntersectionOfTwoLinkedLists {
    public static void launch() {
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
//        ListNode headA = ListUtil.arrToListNode(new int[]{4, 1});
//        ListNode headB = ListUtil.arrToListNode(new int[]{5, 6, 1});
//        ListNode common = ListUtil.arrToListNode(new int[]{8, 4, 5});
        ListNode headA = ListUtil.arrToListNode(new int[]{1, 9, 1});
        ListNode headB = ListUtil.arrToListNode(new int[]{3});
        ListNode common = ListUtil.arrToListNode(new int[]{2, 4});
        solution.combineTwoLinkedLists(headA, common);
        solution.combineTwoLinkedLists(headB, common);
        ListNode node = solution.getIntersectionNodeOfficial(headA, headB);
        System.out.println("common head: " + common);
        System.out.println(node == common);
    }

    private void combineTwoLinkedLists(ListNode node, ListNode commonNode) {
        while (node != null && node.next != null) {
            node = node.next;
        }
        node.next = commonNode;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0, bLength = 0;
        ListNode indexA = headA;
        ListNode indexB = headB;
        while (indexA != null) {
            indexA = indexA.next;
            aLength++;
        }
        while (indexB != null) {
            indexB = indexB.next;
            bLength++;
        }
        if (aLength > bLength) {
            for (int i = 0; i < aLength - bLength; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < bLength - aLength; i++) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 官方解法：通过双指针移动的距离消除长度差
     */
    public ListNode getIntersectionNodeOfficial(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

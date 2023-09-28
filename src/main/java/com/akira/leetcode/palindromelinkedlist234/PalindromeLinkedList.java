package com.akira.leetcode.palindromelinkedlist234;


import com.akira.leetcode.common.ListNode;
import com.akira.leetcode.util.ListUtil;

public class PalindromeLinkedList {

    public static void launch() {
        PalindromeLinkedList solution = new PalindromeLinkedList();
        boolean flag = solution.isPalindrome(ListUtil.arrToListNode(new int[] { 1, 2, 2, 1 }));
        System.out.println(flag);
    }

    /**
     * 获取中间节点的方式：快慢指针 快指针step = 2 慢指针 step = 1 快指针走完 慢指针走一半 得到中间节点
     * 方法一:
     *     复制链表值到数组列表中
     *     使用双指针法判断是否为回文
     * 方法二：
     *      反转一半链表后进行比较
     * 方法三：
     *      递归 比较复杂 主要是利用递归的反转特性
     *      https://leetcode.cn/problems/palindrome-linked-list/solutions/457059/hui-wen-lian-biao-by-leetcode-solution/
     */

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
}

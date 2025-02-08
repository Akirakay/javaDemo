package com.akira.leetcode.util;

import com.akira.leetcode.common.Node;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.util
 * @className: NodeUtil
 * @author: tzk
 * @description: TODO
 * @date: 2025/2/8 10:08
 * @version: 1.0
 */
public class NodeUtil {
    public static Node buildLinkedList(Integer[][] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        // 第一步：创建所有节点并存储在一个列表中
        Node[] nodes = new Node[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node(arr[i][0]);
        }

        // 第二步：设置 next 指针
        for (int i = 0; i < arr.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // 第三步：设置 random 指针
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][1] != null) {
                nodes[i].random = nodes[arr[i][1]];
            }
        }

        // 返回链表的头节点
        return nodes[0];
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.val + ", ");
            if (current.random != null) {
                System.out.print(current.random.val);
            } else {
                System.out.print("null");
            }
            System.out.print("] -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

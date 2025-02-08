package com.akira.leetcode.common;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.common
 * @className: Node
 * @author: tzk
 * @description: TODO
 * @date: 2025/2/8 10:00
 * @version: 1.0
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

    @Override
    public String toString() {
        return this.val + "";
    }
}

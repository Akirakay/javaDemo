package com.akira.leetcode.util;

import com.akira.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.util
 * @className: TreeNodeUtil
 * @author: tzk
 * @description: TODO
 * @date: 2025/2/10 10:02
 * @version: 1.0
 */
public class TreeNodeUtil {

    // using recursion
    // preorder
    public static void traversalTreeNodeUsingRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        traversalTreeNodeUsingRecursion(node.left);
        traversalTreeNodeUsingRecursion(node.right);
    }

    // using iteration
    // preorder
    public static void traversalTreeNodeUsingIteration(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode cur = node;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
    }

    // build tree node by arr
    public static TreeNode arrToTreeNode(Integer[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < array.length) {
            TreeNode current = queue.poll();

            // 左子节点
            if (i < array.length && array[i] != null) {
                current.left = new TreeNode(array[i]);
                queue.add(current.left);
            }
            i++;

            // 右子节点
            if (i < array.length && array[i] != null) {
                current.right = new TreeNode(array[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}

package com.akira.leetcode.invertbinarytree226;

import com.akira.leetcode.common.TreeNode;
import com.akira.leetcode.util.TreeNodeUtil;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.invertbinarytree226
 * @className: InvertBinaryTree
 * @author: tzk
 * @description: TODO
 * @date: 2025/2/10 10:02
 * @version: 1.0
 */
public class InvertBinaryTree {
    public static void launch() {
        InvertBinaryTree solution = new InvertBinaryTree();
        Integer[] arr = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeNodeUtil.arrToTreeNode(arr);
        System.out.println("原始二叉树：");
        TreeNodeUtil.traversalTreeNodeUsingRecursion(root);
        solution.invertTree(root);
        System.out.println("翻转二叉树：");
        TreeNodeUtil.traversalTreeNodeUsingRecursion(root);
    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

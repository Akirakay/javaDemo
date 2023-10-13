package com.akira.leetcode.maximumdepthofbinarytree104;

import com.akira.leetcode.common.TreeNode;
import com.akira.leetcode.util.ListUtil;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumDepthOfBinaryTree {
    public static void launch() {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        TreeNode treeNode = ListUtil.arrToTreeNode(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(solution.maxDepth(treeNode));
    }

    // solution1: DFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // solution2: BFS
    public int maxDepthUsingBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> list = new LinkedList<>();
        list.add(root);
        int depth = 0;
        int currLevelSize;
        while (!list.isEmpty()) {
            // 获取本层的节点数
            currLevelSize = list.size();
            while (currLevelSize > 0) {
                TreeNode node = list.poll();
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                currLevelSize--;
            }
            // 该层节点数为 0 说明该层已经遍历完毕
            depth++;
        }
        return depth;
    }
}

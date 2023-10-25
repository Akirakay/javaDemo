package com.akira.leetcode.binarytreelevelordertraversal102;


import com.akira.leetcode.common.TreeNode;
import com.akira.leetcode.util.ListUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void launch() {
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();
        TreeNode node = ListUtil.arrToTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<List<Integer>> lists = solution.levelOrder(node);
        if (lists != null) {
            for (List<Integer> list : lists) {
                for (Integer ele : list) {
                    System.out.print(ele + " ");
                }
                System.out.println();
            }
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root != null) {
            Deque<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            while (!nodes.isEmpty()) {
                List<Integer> levelList = new LinkedList<>();
                int size = nodes.size();
                while (size-- > 0) {
                    TreeNode node = nodes.poll();
                    levelList.add(node.val);
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                }
                list.add(levelList);
            }
        }
        return list;
    }

}

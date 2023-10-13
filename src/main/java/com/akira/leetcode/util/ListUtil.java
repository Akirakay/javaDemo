package com.akira.leetcode.util;

import com.akira.leetcode.common.ListNode;
import com.akira.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {
    public static ListNode arrToListNode(int[] arr) {
        if (arr.length > 0) {
            List<ListNode> list = Arrays.stream(arr).boxed().map(item -> new ListNode(item, null))
                    .collect(Collectors.toList());
            for (int i = 0; i < list.size() - 1; i++) {
                ListNode curr = list.get(i);
                curr.next = list.get(i + 1);
            }
            return list.get(0);
        }
        return null;
    }

    public static ListNode arrToCycleListNode(int[] arr, int pos) {
        if (arr.length > 0) {
            List<ListNode> list = Arrays.stream(arr).boxed().map(item -> new ListNode(item, null))
                    .collect(Collectors.toList());
            for (int i = 0; i < list.size() - 1; i++) {
                ListNode curr = list.get(i);
                curr.next = list.get(i + 1);
            }
            if (pos >= 0) {
                list.get(list.size() - 1).next = list.get(pos);
            }
            return list.get(0);
        }
        return null;
    }

    public static TreeNode arrToTreeNode(Integer[] arr) {
        if (arr.length > 0) {
            TreeNode [] nodeArray = new TreeNode[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                Integer ele = arr[i];
                if (ele != null) {
                    TreeNode node = new TreeNode(ele);
                    int left = i * 2 + 1;
                    int right = i * 2 + 2;
                    if (left < arr.length) {
                        node.left = nodeArray[left];
                    }
                    if (right < arr.length) {
                        node.right = nodeArray[right];
                    }
                    nodeArray[i] = node;
                } else {
                    nodeArray[i] = null;
                }
            }
            TreeNode treeNode = nodeArray[0];
            nodeArray = null;
            return treeNode;
        }
        return null;
    }
}

package com.akira.leetcode.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.akira.leetcode.common.ListNode;

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
}

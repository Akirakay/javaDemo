package com.akira.leetcode.partitionlabels763;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.partitionlabels763
 * @className: PartitionLabels
 * @author: tzk
 * @description: TODO
 * @date: 2025/2/17 09:39
 * @version: 1.0
 */
public class PartitionLabels {
    public static void launch() {
        PartitionLabels solution = new PartitionLabels();
        String s = "eccbbbbdec";
//        String s = "ababcbacadefegdehijhklij";
        List<Integer> partitions = solution.partitionLabels(s);
        partitions.forEach(System.out::println);
    }

    /**
     *
     * @param s
     * @return java.util.List<java.lang.Integer>
     * @author Ak1ra
     * @date 2025/2/17 09:41
     * @description
     */
    private List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}

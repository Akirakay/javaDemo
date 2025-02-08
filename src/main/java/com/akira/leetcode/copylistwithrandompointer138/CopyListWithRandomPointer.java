package com.akira.leetcode.copylistwithrandompointer138;

import com.akira.leetcode.common.Node;
import com.akira.leetcode.util.NodeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: javaDemo
 * @package: com.akira.leetcode.copylistwithrandompointer138
 * @className: CopyListWithRandomPointer
 * @author: tzk
 * @description: TODO
 * @date: 2025/2/8 09:58
 * @version: 1.0
 */
public class CopyListWithRandomPointer {
    public static void launch() {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        Integer[][] arr = new Integer[][]{{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};
        Node head = NodeUtil.buildLinkedList(arr);
        Node newHead = solution.copyRandomListOfficial(head);
        NodeUtil.printLinkedList(newHead);
    }

    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    /**
     * official solution
     * @param head
     * @return com.akira.leetcode.common.Node
     * @author Ak1ra
     * @date 2025/2/8 10:51
     * @description
     */
    public Node copyRandomListOfficial(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomListOfficial(head.next);
            headNew.random = copyRandomListOfficial(head.random);
        }
        return cachedNode.get(head);
    }


    /**
     *
     * @param head
     * @return com.akira.leetcode.common.Node
     * @author Ak1ra
     * @date 2025/2/8 10:11
     * @description
     */
    private Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 第一步：创建所有节点并存储在一个Map中
        HashMap<Node, Node> nodeHashMap = new HashMap<>();
        Node index = head;
        while (index != null) {
            Node node = new Node(index.val);
            nodeHashMap.put(index, node);
            index = index.next;
        }

        // 第二步：设置 next 指针
        nodeHashMap.forEach((key, value) -> {
            value.next = nodeHashMap.get(key.next);
            value.random = nodeHashMap.get(key.random);
        });

        // 返回链表的头节点
        return nodeHashMap.get(head);
    }
}

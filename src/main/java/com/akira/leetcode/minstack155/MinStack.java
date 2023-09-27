package com.akira.leetcode.minstack155;


import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;

    private Integer min;

    public MinStack() {
        stack = new Stack<>();
    }

// bad design
//    public void push(int val) {
//        stack.push(val);
//        min = (min == null) ? val : ((min < val) ? min : val);
//    }
//
//    public void pop() {
//        Integer pop = stack.pop();
//        min = (min == null) ? null : ((min < pop) ? min : minInStack());
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return min;
//    }
//
//    private Integer minInStack() {
//        min = null;
//        Iterator<Integer> iterator = stack.iterator();
//        while (iterator.hasNext()) {
//            int val = iterator.next();
//            min = (min == null) ? val : ((min < val) ? min : val);
//        }
//        return min;
//    }

    // 1. 使用辅助栈 保存最小值
    // 每次push、pop操作都对辅助栈也进行相同操作 辅助栈的push 只push 当前栈的最小值
    // 2. 使用栈中保存于最小值的差值
    // 栈中每个元素代表的是要压入元素与当前栈中最小值的差值
    // 当弹出元素小于0时，说明弹出元素是当前栈中的最小值，要更新最小值
    /**
     * if(pop<0){
     *         // 因为对于当前弹出的元素而言，计算压入栈中的值时，计算的是该元素与【未压入】该元素时
     *         // 栈中元素的最小值的差值，故弹出该元素后栈中的最小值就是未压入该元素时的最小值
     *         // 即当前元素的值（min）减去两者的差值
     *         long lastMin = min;
     *         min = lastMin - pop;
     *     }
     */
    // 若大于等于0，不会对min有影响

}

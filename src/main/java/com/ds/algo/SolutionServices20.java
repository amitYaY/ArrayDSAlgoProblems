package com.ds.algo;

import java.util.ArrayList;
import java.util.List;

public class SolutionServices20 {

    class MinStack {

        private List<Integer> stack = null;
        private List<Integer> minStack = null;

        private Integer min;

        public MinStack() {
            stack = new ArrayList<>();
            minStack = new ArrayList<>();
            min = null;
        }

        public void push(int val) {
            if(min == null) {
                min = val;
            } else if(val <= min) {
                min = val;
            }
            minStack.add(min);
            stack.add(val);
        }

        public void pop() {
            stack.remove(stack.size()-1);
            minStack.remove(minStack.size()-1);
            min = minStack.size() > 0 ? minStack.get(stack.size()-1) : null;
        }

        public int top() {
            return stack.get(stack.size()-1);
        }

        public int getMin() {
            return minStack.get(stack.size()-1);
        }

    }
}

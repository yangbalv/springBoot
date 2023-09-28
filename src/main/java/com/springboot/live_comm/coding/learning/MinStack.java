package com.springboot.live_comm.coding.learning;


class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(395);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(267);
        minStack.push(29);
        System.out.println(minStack.getMin());
        minStack.push(-482);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(-108);
        minStack.push(-251);
        System.out.println(minStack.getMin());
        minStack.push(-439);

    }

    int[] stack;
    int[] index;
    static int LEN = 10;
    int size;
    int min;


    public MinStack() {
        stack = new int[LEN];
        index = new int[LEN];
        size = 0;

    }

    public void push(int val) {
        if (size == 0) {
            min = val;
        }

        if (size == stack.length) {
            int[] stackx = new int[stack.length + LEN];
            System.arraycopy(stack, 0, stackx, 0, stack.length);
            stack = stackx;
            int[] indexx = new int[index.length + LEN];
            System.arraycopy(index, 0, indexx, 0, index.length);
            index = indexx;
        }
        stack[size] = val;
        if (val <= min) {
            min = val;
            index[size] = size;
        } else {
            index[size] = index[size - 1];
        }
        size++;
    }

    public void pop() {
        size--;
        if (size > 0) {
            min = stack[index[size - 1]];
        }
    }

    public int top() {
        return stack[size - 1];
    }

    public int getMin() {
        return stack[index[size - 1]];
    }
}

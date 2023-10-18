package com.springboot.live_comm.coding.learning;

import java.util.ArrayDeque;
import java.util.Queue;


class BSTIterator {
    Queue<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        input(root);

    }

    public void input(TreeNode root) {
        if (root != null) {

            input(root.left);
            stack.add(root);
            input(root.right);

        }
    }

    public int next() {
        return stack.remove().val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }
}
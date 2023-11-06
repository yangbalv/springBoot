package com.springboot.live_comm.coding.learning;

import java.util.*;

/**
 * @ClassName: AA
 * @Author : ever
 * @Date :2023/11/3  11:42
 * @Description: TODO
 * @Version :1.0
 */
public class AA {
    // Definition for a Node.
    class NodeX {
        public int val;
        public List<NodeX> neighbors;

        public NodeX() {
            val = 0;
            neighbors = new ArrayList<NodeX>();
        }

        public NodeX(int _val) {
            val = _val;
            neighbors = new ArrayList<NodeX>();
        }

        public NodeX(int _val, ArrayList<NodeX> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Map<NodeX, NodeX> map = new HashMap<>();

    public NodeX cloneGraph(NodeX node) {
        if (map.containsKey(node)){

        }
        NodeX new
        stack

    }

}

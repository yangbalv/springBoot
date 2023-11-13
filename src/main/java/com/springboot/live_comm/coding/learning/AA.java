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
        NodeX newNode;
        if (!map.containsKey(node)) {
            newNode = new NodeX(node.val);
            List<NodeX> nodeXList = new ArrayList<>();
            map.put(node, newNode);
            for (NodeX neighbor : node.neighbors) {
                nodeXList.add(cloneGraph(neighbor));
            }
            newNode.neighbors = nodeXList;
        } else {
            newNode = map.get(node);
        }
        return newNode;
    }

    //    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        if (equations==null||equations.size()!= values.length){
//            return new double[]{};
//        }
//        for (List<String> equation : equations) {
//            String s1 = equation.get(0);
//            String s2 = equation.get(1);
//        }
//
//    }
    public static void main(String[] args) {
        AA aa = new AA();
        System.out.println(aa.equationsPossible2(new String[]{"a==b","b!=a"}));
    }

    public boolean equationsPossible2(String[] equations) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                if (map.get(equation.charAt(0)) == null) {
                    Set<Character> set = new HashSet<>();
                    set.add(equation.charAt(0));
                    map.put(equation.charAt(0), set);
                }
                if (map.get(equation.charAt(3)) == null) {
                    Set<Character> set = new HashSet<>();
                    set.add(equation.charAt(3));
                    map.put(equation.charAt(3), set);
                }
                map.get(equation.charAt(0)).addAll(map.get(equation.charAt(3)));
                for (Character character : map.get(equation.charAt(3))) {
                    map.put(character, map.get(equation.charAt(0)));
                }
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (map.get(equation.charAt(0)) == null && map.get(equation.charAt(3)) == null && equation.charAt(0) == equation.charAt(3)) {
                    return false;
                }
                if (map.get(equation.charAt(0)) != null && map.get(equation.charAt(3)) != null && map.get(equation.charAt(0)) == map.get(equation.charAt(3))) {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean equationsPossible(String[] equations) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Set<Character>> setMap = new HashMap<>();
        Map<Integer, Set<Integer>> upsetDown = new HashMap<>();
        int p = 1;
        for (int i = 0; i < equations.length; i++) {
            char c1 = equations[i].charAt(0);
            char c2 = equations[i].charAt(3);
            p = getP(map, setMap, upsetDown, p, c1);
            p = getP(map, setMap, upsetDown, p, c2);
            Integer c1Num = map.get(c1);
            Integer c2Num = map.get(c2);
            Set<Character> c1Set = setMap.get(c1Num);
            Set<Character> c2Set = setMap.get(c2Num);
            Set<Integer> upsetDownSet1 = upsetDown.get(-c1Num);
            Set<Integer> upsetDownSet2 = upsetDown.get(-c2Num);

            if (equations[i].charAt(1) == '=') {
                if (!c1Num.equals(c2Num)) {
                    if (upsetDown.get(-c1Num).contains(c2Num) || upsetDown.get(-c2Num).contains(c1Num)) {
                        return false;
                    } else {
                        c1Set.addAll(c2Set);
                        upsetDownSet1.addAll(upsetDownSet2);
                        for (Character character : c2Set) {
                            map.put(character, c1Num);
                        }
                    }
                }
            } else {
                upsetDown.get(-c1Num).add(c2Num);
                upsetDown.get(-c2Num).add(c1Num);
                if (map.get(c2).equals(map.get(c1))) {
                    return false;
                }
            }

        }
        return true;
    }

    private int getP(Map<Character, Integer> map, Map<Integer, Set<Character>> setMap, Map<Integer, Set<Integer>> upsetDown, int p, char c2) {
        if (!map.containsKey(c2)) {
            Set<Character> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            set1.add(c2);
            map.put(c2, p);
            setMap.put(p, set1);
            upsetDown.put(-p, set2);
            p++;
        }
        return p;
    }

}

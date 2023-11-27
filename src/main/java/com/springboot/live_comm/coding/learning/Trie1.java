package com.springboot.live_comm.coding.learning;

import java.util.HashSet;
import java.util.Set;

class Trie1 {
    //
//    Trie（发音类似 "try"）或者说 前缀树
//    是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
//    请你实现 Trie
//    类：
//
//    Trie() 初始化前缀树对象。
//    void insert(String word) 向前缀树中插入字符串 word 。
//    boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
//    boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
//    示例：
//    输入
//["Trie","insert","search","search","startsWith","insert","search"]
//        [[],["apple"],["apple"],["app"],["app"],["app"],["app"]]
//    输出
//[null,null,true,false,true,null,true]
//
//    解释
//    Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
//
//
//    提示：
//
//            1<=word.length,prefix.length <=2000
//    word 和
//    prefix 仅由小写英文字母组成
//    insert、
//    search 和
//    startsWith 调用次数
//    总计 不超过 3*104次
    private Set<String> trieSet;
    private Set<String> containsSet;

    public Trie1() {
        trieSet = new HashSet<>();
        containsSet = new HashSet<>();
    }

    public void insert(String word) {
        containsSet.add(word);
        if (!startsWith(word)) {
            int i = getIndex(word, 0, word.length() - 1);
            for (; i < word.length(); i++) {
                trieSet.add(word.substring(0, i + 1));
            }
            for (String s : trieSet) {
                System.out.println(s);
            }
        }

    }

    public int getIndex(String word, int left, int right) {
        if (left == right) {
            return left;
        }
        int p = (left + right + 1) / 2;
        if (trieSet.contains(word.substring(0, p))) {
            if (p + 1 < word.length()) {
                if (!trieSet.contains(word.substring(0, p + 1))) {
                    return p;
                } else {
                    return getIndex(word, p + 1, right);
                }
            } else {
                return p;
            }

        } else {
            return getIndex(word, left, p - 1);
        }

    }

    public boolean search(String word) {
        return containsSet.contains(word);
    }

    public boolean startsWith(String prefix) {
        return trieSet.contains(prefix);
    }

    public static void main(String[] args) {

        Trie1 trie1 = new Trie1();
        trie1.insert("apple");
        System.out.println(trie1.search("apple"));  // 返回 True
        System.out.println(trie1.search("app"));    // 返回 False
        System.out.println(trie1.startsWith("app"));  // 返回 True
        trie1.insert("app");
        trie1.search("app");
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
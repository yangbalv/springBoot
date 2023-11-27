package com.springboot.live_comm.coding.learning;

public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie util = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (util.children[index] == null) {
                util.children[index] = new Trie();
            }
            util = util.children[index];
        }
        util.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public Trie searchPrefix(String word) {
        Trie util = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (util.children[index] == null) {
                return null;
            }
            util = util.children[index];
        }
        return util;

    }

    public static void main(String[] args) {

        Trie trie1 = new Trie();
        trie1.insert("apple");
        System.out.println(trie1.search("apple"));  // 返回 True
        System.out.println(trie1.search("app"));    // 返回 False
        System.out.println(trie1.startsWith("app"));  // 返回 True
        trie1.insert("app");
        trie1.search("app");
    }
}

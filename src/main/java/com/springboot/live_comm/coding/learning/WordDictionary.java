package com.springboot.live_comm.coding.learning;

import java.util.ArrayDeque;
import java.util.Queue;

public class WordDictionary {
    private WordDictionary[] wordDictionaries;
    private boolean isEnd;

    public WordDictionary() {
        wordDictionaries = new WordDictionary[26];
        isEnd = false;
    }

    public void addWord(String word) {
        WordDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.wordDictionaries[index] == null) {
                node.wordDictionaries[index] = new WordDictionary();
            }
            node = node.wordDictionaries[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Queue<WordDictionary> queue = new ArrayDeque<>();
        queue.add(this);

        for (int i = 0; i < word.length(); i++) {
            if (queue.size() == 0) {
                return false;
            }
            char ch = word.charAt(i);

            int size = queue.size();
            for (int j = 0; j < size; j++) {
                WordDictionary wordDictionary = queue.remove();
                if (ch == '.') {
                    for (int k = 0; k < wordDictionary.wordDictionaries.length; k++) {

                        if (wordDictionary.wordDictionaries[k] != null) {
                            queue.add(wordDictionary.wordDictionaries[k]);
                        }

                    }
                } else {
                    if (wordDictionary.wordDictionaries[ch - 'a'] != null) {
                        queue.add(wordDictionary.wordDictionaries[ch - 'a']);
                    }

                }
            }

        }
        for (WordDictionary wordDictionary : queue) {
            if (wordDictionary.isEnd) {
                return true;
            }
        }
        return false;
    }

//    ["WordDictionary",
//            "addWord","addWord","addWord","addWord",
//            "search","search",
//            "addWord",
//            "search","search","search","search","search","search"]
//
//    [[],
//            ["at"],["and"],["an"],["add"],
//            ["a"],[".at"],
//            ["bat"],
//            [".at"],["an."],["a.d."],["b."],["a.d"],["."]]

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        System.out.println("null");
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at")); // 返回 True
        System.out.println(wordDictionary.search("an.")); // 返回 True
        System.out.println(wordDictionary.search("a.d.")); // 返回 True
        System.out.println(wordDictionary.search("b.")); // 返回 True
        System.out.println(wordDictionary.search("a.d")); // 返回 True
        System.out.println(wordDictionary.search(".")); // 返回 True

//                [null,null,null,null,null,true,false,null,true,true,false,true,true,true]

//答案：
//        [null,null,null,null,null,false,false,null,true,true,false,false,true,false]
    }
}

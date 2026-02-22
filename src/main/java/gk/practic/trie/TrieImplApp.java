package gk.practic.trie;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isEnd;
    String word = "";
}

public class TrieImplApp {
    private TrieNode root;
    public TrieImplApp() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (Character ch: word.toCharArray()) {
            int index = ch - 'a';
            if(node.child[index] == null) {
                node.child[index] = new TrieNode();
            }
            node = node.child[index];
        }
        node.isEnd = true;
        node.word = word;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (Character ch: word.toCharArray()) {
            int index = ch - 'a';
            if(node.child[index] == null) {
                return false;
            }
            node = node.child[index];
        }
        if(node.isEnd) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (Character ch: prefix.toCharArray()) {
            int index = ch - 'a';
            if(node.child[index] == null) {
                return false;
            }
            node = node.child[index];
        }
        return true;
    }

    public List<String> getSuggestion(String prefix) {
        List<String> list = new ArrayList<>();
        TrieNode node = root;
        for (Character ch: prefix.toCharArray()) {
            int index = ch - 'a';
            if(node.child[index] == null) {
                return list;
            }
            node = node.child[index];
        }
        dfsTrie(node, list);
        return list;
    }

    private void dfsTrie(TrieNode node, List<String> list) {
        if (node == null) return;
        if (node.isEnd) list.add(node.word);
        for (int i = 0; i < 26; i++) {
            dfsTrie(node.child[i], list);
        }
    }
}

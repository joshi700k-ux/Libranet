import java.util.HashMap;
import java.util.Map;

class TrieNode {

    Map<Character, TrieNode> children;

    boolean endWord;

    public TrieNode() {

        children = new HashMap<>();
        endWord = false;
    }
}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;

        word = word.toLowerCase();

        for (char ch : word.toCharArray()) {

            current.children.putIfAbsent(
                    ch,
                    new TrieNode()
            );

            current = current.children.get(ch);
        }

        current.endWord = true;
    }

    public boolean search(String word) {

        TrieNode current = root;

        word = word.toLowerCase();

        for (char ch : word.toCharArray()) {

            if (!current.children.containsKey(ch)) {
                return false;
            }

            current = current.children.get(ch);
        }

        return current.endWord;
    }

    public boolean startsWith(String prefix) {

        TrieNode current = root;

        prefix = prefix.toLowerCase();

        for (char ch : prefix.toCharArray()) {

            if (!current.children.containsKey(ch)) {
                return false;
            }

            current = current.children.get(ch);
        }

        return true;
    }
}
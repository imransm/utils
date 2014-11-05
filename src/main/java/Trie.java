import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Imran on 9/20/2014.
 * <p/>
 * English alphabet, small letters only.
 */
public class Trie {
    private char key;
    private Trie[] children;
    private boolean isEndOfWord;

    public Trie(char key) {
        this.key = key;
        children = new Trie[26];
    }

    public static Trie buildTrie(String[] words) {
        Trie root = new Trie('\0');
        if (words == null || words.length == 0)
            return root;
        for (String word : words) {
            root.insertWord(word);
        }
        return root;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        char[] tokens = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < tokens.length; i++) {
            char searchFor = tokens[i];
            int index = searchFor - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
            }
            boolean lastCharToSearch = (i == tokens.length - 1);
            if (lastCharToSearch)
                return node.isEndOfWord;
        }
        return false;
    }

    public boolean isPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0)
            return false;
        char[] tokens = prefix.toCharArray();
        Trie node = this;
        for (int i = 0; i < tokens.length; i++) {
            char searchFor = tokens[i];
            int index = searchFor - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }


    public void insertWord(String word) {
        if (word == null)
            return;
        char[] tokens = word.toCharArray();
        Trie node = this;
        for (int i = 0; i < tokens.length; i++) {
            char toInsert = tokens[i];
            int index = toInsert - 'a';
            if (node.children[index] == null) {
                Trie child = new Trie(tokens[i]);
                if (i == tokens.length - 1) {
                    child.isEndOfWord = true;
                }
                node.children[index] = child;
                node = child;
            } else {
                node = node.children[index];
            }
        }
    }

    public List<String> listAllWithPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0)
            return Collections.emptyList();
        char[] tokens = prefix.toCharArray();
        Trie node = this;
        for (char searchFor : tokens) {
            int index = searchFor - 'a';
            if (node.children[index] == null) {
                return Collections.emptyList();
            }
            node = node.children[index];
        }
        // Now node contains last char of prefix.
        // Search among all children of node and return list of words appending to it.
        List<String> toReturn = new ArrayList<String>();
        for (Trie child : node.children) {
            if (child != null) {
                List<String> suffixList = child.findAllSuffixes();
                for (String suffix : suffixList) {
                    toReturn.add(prefix + suffix);
                }
            }
        }
        return toReturn;
    }

    private List<String> findAllSuffixes() {
        List<String> suffixList = new ArrayList<String>();
        findSuffixesInternal(this, String.valueOf(this.key), suffixList);
        return suffixList;
    }

    private void findSuffixesInternal(Trie node, String currentSuffix, List<String> suffixList) {
        if (node != null) {
            if (node.isEndOfWord && currentSuffix.length() > 0)
                suffixList.add(currentSuffix);
            for (Trie child : node.children) {
                if(child != null)
                findSuffixesInternal(child, currentSuffix + child.key, suffixList);
            }
        }
    }


}



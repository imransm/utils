import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void shouldSearchForAStringInTrie() {
        String[] words = {"apple", "bat", "cat", "ball", "ant", "cap", "java", "soft", "tree", "trie"};
        Trie trie = Trie.buildTrie(words);
        for(String word: words) {
            assertTrue(trie.search(word));
        }
        assertFalse(trie.search("amazon"));
    }

    @Test
    public void shouldCheckIfPrefixForAStringInTrie() {
        String[] words = {"apple", "bat", "cat", "ball", "ant", "cap", "java", "soft", "tree", "trie"};
        Trie trie = Trie.buildTrie(words);
        assertFalse(trie.isPrefix("amazon"));
        assertTrue(trie.isPrefix("app"));
        assertTrue(trie.isPrefix("an"));
        assertTrue(trie.isPrefix("ca"));
        assertTrue(trie.isPrefix("tri"));
        assertFalse(trie.isPrefix("tro"));
    }

    @Test
    public void shouldListAllWordsForAGivenPrefix() {
        String[] words = {"apple", "bat", "cat", "ball", "ant", "cap", "java", "soft", "tree", "trie", "trap", "troll"};
        Trie trie = Trie.buildTrie(words);
        List<String> allWordsWithPrefix = trie.listAllWithPrefix("tr");
        assertTrue(allWordsWithPrefix.contains("tree"));
        assertTrue(allWordsWithPrefix.contains("trie"));
        assertTrue(allWordsWithPrefix.contains("troll"));
        assertTrue(allWordsWithPrefix.contains("trap"));
        allWordsWithPrefix = trie.listAllWithPrefix("a");
        assertTrue(allWordsWithPrefix.contains("apple"));
        assertTrue(allWordsWithPrefix.contains("ant"));

    }


}
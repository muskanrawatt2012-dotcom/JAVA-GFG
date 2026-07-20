import java.util.ArrayList;

class Solution {
    // Trie Node class
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int frequency = 0; // Tracks how many words pass through this node
    }
    
    // Method to insert a word into the Trie
    private void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            current.frequency++; // Increment the frequency of this character node
        }
    }
    
    // Method to find the unique prefix for a word
    private String findPrefix(TrieNode root, String word) {
        TrieNode current = root;
        StringBuilder prefix = new StringBuilder();
        
        for (char ch : word.toCharArray()) {
            prefix.append(ch);
            int index = ch - 'a';
            current = current.children[index];
            
            // If this node is visited by only one word, we found our unique prefix
            if (current.frequency == 1) {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }

    public ArrayList<String> findPrefixes(String[] arr) {
        TrieNode root = new TrieNode();
        
        // Step 1: Insert all words into the Trie
        for (String word : arr) {
            insert(root, word);
        }
        
        // Step 2: Find the shortest unique prefix for each word
        ArrayList<String> result = new ArrayList<>();
        for (String word : arr) {
            result.add(findPrefix(root, word));
        }
        
        return result;
    }
}
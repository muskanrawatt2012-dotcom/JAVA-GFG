class Solution {
    private int maxLen = 0;

    public int longestConsecutive(Node root) {
        if (root == null) return -1;
        
        maxLen = 0;
        dfs(root, root.data, 0);
        
        return maxLen >= 2 ? maxLen : -1;
    }

    private void dfs(Node node, int expectedValue, int currentLength) {
        if (node == null) return;

        if (node.data == expectedValue) {
            currentLength++;
        } else {
            currentLength = 1;
        }

        maxLen = Math.max(maxLen, currentLength);

        dfs(node.left, node.data + 1, currentLength);
        dfs(node.right, node.data + 1, currentLength);
    }
}
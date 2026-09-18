class Solution {
    private int minDiff = Integer.MAX_VALUE;
    private Integer prev = null;

    public int absDiff(Node root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, root.data - prev);
        }
        prev = root.data;

        inorder(root.right);
    }
}
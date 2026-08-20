class Solution {
    int maxDiffUtil(Node node, int[] maxDiff) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.left == null && node.right == null) {
            return node.data;
        }

        int leftMin = maxDiffUtil(node.left, maxDiff);
        int rightMin = maxDiffUtil(node.right, maxDiff);

        int minChild = Math.min(leftMin, rightMin);

        maxDiff[0] = Math.max(maxDiff[0], node.data - minChild);

        return Math.min(node.data, minChild);
    }

    int maxDiff(Node root) {
        int[] maxDiff = new int[]{Integer.MIN_VALUE};
        maxDiffUtil(root, maxDiff);
        return maxDiff[0];
    }
}
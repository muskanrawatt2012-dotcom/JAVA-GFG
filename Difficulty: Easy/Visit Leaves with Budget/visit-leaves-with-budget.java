class Solution {
    public int getCount(Node root, int k) {
        if (root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        queue.add(root);
        levels.add(1);

        int count = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int level = levels.poll();

            if (node.left == null && node.right == null) {
                if (k >= level) {
                    k -= level;
                    count++;
                } else {
                    break;
                }
            }

            if (node.left != null) {
                queue.add(node.left);
                levels.add(level + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                levels.add(level + 1);
            }
        }

        return count;
    }
}
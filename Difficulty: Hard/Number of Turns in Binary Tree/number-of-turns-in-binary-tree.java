class Solution {
    private static int count;

    private static Node findLCA(Node root, int p, int q) {
        if (root == null) return null;
        if (root.data == p || root.data == q) return root;

        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    private static boolean countTurns(Node root, int target, boolean turn) {
        if (root == null) return false;
        if (root.data == target) return true;

        if (turn) {
            if (countTurns(root.left, target, turn)) return true;
            if (countTurns(root.right, target, !turn)) {
                count++;
                return true;
            }
        } else {
            if (countTurns(root.right, target, turn)) return true;
            if (countTurns(root.left, target, !turn)) {
                count++;
                return true;
            }
        }
        return false;
    }

    public static int numberOfTurns(Node root, int p, int q) {
        Node lca = findLCA(root, p, q);
        if (lca == null) return -1;

        count = 0;

        if (lca.data != p && lca.data != q) {
            countTurns(lca.left, p, true);
            countTurns(lca.right, p, false);
            countTurns(lca.left, q, true);
            countTurns(lca.right, q, false);
            return count + 1;
        }

        int target = (lca.data == p) ? q : p;
        countTurns(lca.left, target, true);
        countTurns(lca.right, target, false);

        return count == 0 ? -1 : count;
    }
}
import java.util.HashMap;

class Solution {
    // Global or pass-by-reference index to track the current root in pre[]
    private int preIndex;

    public Node constructBinaryTree(int[] pre, int[] preMirror) {
        preIndex = 0;
        
        // Map to store element -> index for O(1) lookups in preMirror[]
        HashMap<Integer, Integer> mirrorMap = new HashMap<>();
        for (int i = 0; i < preMirror.length; i++) {
            mirrorMap.put(preMirror[i], i);
        }
        
        return buildTree(pre, preMirror, 0, preMirror.length - 1, mirrorMap);
    }

    private Node buildTree(int[] pre, int[] preMirror, int mirrorStart, int mirrorEnd, HashMap<Integer, Integer> mirrorMap) {
        // Base case: if the range is invalid or all nodes are processed
        if (preIndex >= pre.length || mirrorStart > mirrorEnd) {
            return null;
        }

        // Create the root node with the current pre element
        Node root = new Node(pre[preIndex++]);

        // If this node has no children (leaf node), return it
        if (mirrorStart == mirrorEnd || preIndex >= pre.length) {
            return root;
        }

        // The next element in pre[] is the left child of the current root
        int leftChildVal = pre[preIndex];
        
        // Find the index of this left child in the preMirror[] array
        int mirrorIndex = mirrorMap.get(leftChildVal);

        // In preMirror[], the elements from mirrorIndex to mirrorEnd 
        // represent the left subtree of the original tree
        root.left = buildTree(pre, preMirror, mirrorIndex, mirrorEnd, mirrorMap);
        
        // The elements from mirrorStart + 1 to mirrorIndex - 1
        // represent the right subtree of the original tree
        root.right = buildTree(pre, preMirror, mirrorStart + 1, mirrorIndex - 1, mirrorMap);

        return root;
    }
}
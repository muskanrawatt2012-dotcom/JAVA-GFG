 /* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    public void toSumTree(Node root) {
        convert(root);
    }
    
    int convert(Node root) {
        if (root == null)
            return 0;
        
       
        int leftSum = convert(root.left);
        
       
        int rightSum = convert(root.right);
        
      
        int oldValue = root.data;
        
       
        root.data = leftSum + rightSum;
        
       
        return oldValue + root.data;
    }
} 
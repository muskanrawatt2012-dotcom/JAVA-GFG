import java.util.List;
import java.util.Stack;

class Solution {
    public boolean canRepresentBST(List<Integer> arr) {
        // Create an empty stack
        Stack<Integer> stack = new Stack<>();
        
        // Initialize current root as the minimum possible value
        int root = Integer.MIN_VALUE;
        
        // Traverse the given array
        for (int i = 0; i < arr.size(); i++) {
            int val = arr.get(i);
            
            // If we find a node which is on the right side and 
            // smaller than the root, it's not a valid BST.
            if (val < root) {
                return false;
            }
            
            // If val is greater than stack's top, keep removing 
            // elements and make the last removed item the new root.
            while (!stack.isEmpty() && stack.peek() < val) {
                root = stack.pop();
            }
            
            // Push the current element into the stack
            stack.push(val);
        }
        
        return true;
    }
}
import java.util.*;

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2) return false;

            Map<Integer, Integer> freqMap = new HashMap<>();

            for (int i = 0; i < size1; i++) {
                Node curr1 = q1.poll();
                freqMap.put(curr1.data, freqMap.getOrDefault(curr1.data, 0) + 1);
                if (curr1.left != null) q1.add(curr1.left);
                if (curr1.right != null) q1.add(curr1.right);

                Node curr2 = q2.poll();
                freqMap.put(curr2.data, freqMap.getOrDefault(curr2.data, 0) - 1);
                if (curr2.left != null) q2.add(curr2.left);
                if (curr2.right != null) q2.add(curr2.right);
            }

            for (int count : freqMap.values()) {
                if (count != 0) return false;
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}
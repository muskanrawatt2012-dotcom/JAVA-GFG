
class Solution {
    public int maxAmount(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int tickets : arr) {
            pq.add(tickets);
        }

        long totalAmount = 0;
        long modulo = 1000000007;

        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) {
                break;
            }
            int currentMax = pq.poll();
            totalAmount = (totalAmount + currentMax) % modulo;
            
            if (currentMax > 1) {
                pq.add(currentMax - 1);
            }
        }

        return (int) totalAmount;
    }
}
class Solution {
    public int countMinOperations(int arr[]) {
        int totalIncrements = 0;
        int maxDoubles = 0;

        for (int val : arr) {
            int currentDoubles = 0;
            while (val > 0) {
                if (val % 2 == 1) {
                    totalIncrements++;
                    val--;
                } else {
                    currentDoubles++;
                    val /= 2;
                }
            }
            maxDoubles = Math.max(maxDoubles, currentDoubles);
        }

        return totalIncrements + maxDoubles;
    }
}
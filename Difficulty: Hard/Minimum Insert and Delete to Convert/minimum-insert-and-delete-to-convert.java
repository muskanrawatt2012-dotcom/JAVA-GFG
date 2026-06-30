

class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        
        ArrayList<Integer> filteredA = new ArrayList<>();
        for (int val : a) {
            if (binarySearch(b, val)) {
                filteredA.add(val);
            }
        }
        
        int lcsLength = lengthOfLIS(filteredA);
        
        return (n - lcsLength) + (m - lcsLength);
    }
    
    private boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    
    private int lengthOfLIS(ArrayList<Integer> nums) {
        if (nums.isEmpty()) return 0;
        
        ArrayList<Integer> tails = new ArrayList<>();
        for (int num : nums) {
            int idx = Collections.binarySearch(tails, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx == tails.size()) {
                tails.add(num);
            } else {
                tails.set(idx, num);
            }
        }
        return tails.size();
    }
}
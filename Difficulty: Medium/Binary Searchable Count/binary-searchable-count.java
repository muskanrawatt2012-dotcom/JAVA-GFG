class Solution {
    public int binarySearchable(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            int target = arr[i];
            boolean ok = true;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (mid == i) {
                    break;
                }

                if (mid < i) {
                    if (arr[mid] < target) {
                        l = mid + 1;
                    } else {
                        ok = false;
                        break;
                    }
                } else {
                    if (arr[mid] > target) {
                        r = mid - 1;
                    } else {
                        ok = false;
                        break;
                    }
                }
            }

            if (ok) count++;
        }

        return count;
    }
}
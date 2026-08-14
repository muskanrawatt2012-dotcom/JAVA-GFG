class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        java.util.List<Long> list = new java.util.ArrayList<>();
        long current = s;
        long sum = s;
        list.add(current);

        for (int num : arr) {
            current = sum + num;
            list.add(current);
            sum += current;
            if (current > x) {
                break;
            }
        }

        long target = x;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (target >= list.get(i)) {
                target -= list.get(i);
            }
        }

        return target == 0;
    }
}
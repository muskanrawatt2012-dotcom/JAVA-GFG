class Solution {
    public int maxArea(List<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        int max = 0;

        while (left < right) {
            int h = Math.min(height.get(left), height.get(right));
            int width = right - left - 1;
            max = Math.max(max, h * width);

            if (height.get(left) < height.get(right)) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}


class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }
        generateNumbers(0, 1, n, result);
        return result;
    }

    private static void generateNumbers(int currentNum, int startDigit, int n, ArrayList<Integer> result) {
        if (n == 0) {
            result.add(currentNum);
            return;
        }

        for (int i = startDigit; i <= 9; i++) {
            generateNumbers(currentNum * 10 + i, i + 1, n - 1, result);
        }
    }
}
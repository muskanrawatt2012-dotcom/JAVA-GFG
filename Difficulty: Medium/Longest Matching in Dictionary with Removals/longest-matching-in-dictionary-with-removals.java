class Solution {
    public String findLongestWord(String s, List<String> d) {
        String ans = "";
        for (String word : d) {
            if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                if (isSubsequence(word, s)) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    private boolean isSubsequence(String w, String s) {
        int i = 0, j = 0;
        while (i < w.length() && j < s.length()) {
            if (w.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == w.length();
    }
}
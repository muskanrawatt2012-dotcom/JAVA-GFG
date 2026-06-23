class Solution {
    int maxPeopleDefeated(int p) {
        int count = 0;
        int i = 1;

        while (p >= i * i) {
            p -= i * i;
            count++;
            i++;
        }

        return count;
    }
}
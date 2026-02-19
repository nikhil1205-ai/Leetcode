class Solution {
    public int countBinarySubstrings(String s) {
        if(s.length() < 2) return 0;
        int prev = 0;      //previous group length
        int curr = 1;      //current group length
        int total = 0;
        int i = 1;

        while(i < s.length()) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                total += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
            i++;
        }

        total += Math.min(prev, curr);      //last group
        return total;
    }
}
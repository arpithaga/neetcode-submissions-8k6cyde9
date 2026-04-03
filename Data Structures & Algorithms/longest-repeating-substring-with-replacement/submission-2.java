class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int i = 0, j = 0;
            int k1 = 0;
            while (j < s.length()) {
                if (s.charAt(j) != c)
                    k1++;
                while (k1 > k) {
                    if (s.charAt(i) != c) {
                        k1--;
                    }
                    i++;
                }
                max = Math.max(max, j - i + 1);
                j++;
            }
        }
        return max == 0 && s.length() > 0 ? 1 : max;
    }
}
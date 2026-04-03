class Solution {
    public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) return false;

    int[] freq = new int[26];
    for (char c : s1.toCharArray()) {
        freq[c - 'a']++;
    }

    int left = 0, right = 0;
    int needed = s1.length();

    while (right < s2.length()) {
        char c = s2.charAt(right);
        if (freq[c - 'a'] > 0) {
            needed--;
        }
        freq[c - 'a']--;
        right++;

        if (needed == 0) return true;

        if (right - left == s1.length()) {
            char leftChar = s2.charAt(left);
            if (freq[leftChar - 'a'] >= 0) {
                needed++;
            }
            freq[leftChar - 'a']++;
            left++;
        }
    }
    return false;
}

}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m > n) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < m; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        for (int i = m; i < n; i++) {
            if (matches == 26) return true;

            // Incoming character (right)
            int r = s2.charAt(i) - 'a';
            s2Count[r]++;
            if (s2Count[r] == s1Count[r]) {
                matches++;
            } else if (s2Count[r] == s1Count[r] + 1) {
                matches--;
            }

            // Outgoing character (left)
            int l = s2.charAt(i - m) - 'a';
            s2Count[l]--;
            if (s2Count[l] == s1Count[l]) {
                matches++;
            } else if (s2Count[l] == s1Count[l] - 1) {
                matches--;
            }
        }

        return matches == 26;
    }
}
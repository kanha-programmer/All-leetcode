class Solution {
    public String smallestPalindrome(String s) {
        int[] fre = new int[26];

        for (char c : s.toCharArray()) {
            fre[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < fre[i] / 2; j++) {
                left.append((char)(i + 'a'));
            }
            if (fre[i] % 2 == 1) {
                mid = (char)(i + 'a');
            }
        }

        String ans = left.toString();
        if (mid != 0) ans += mid;
        ans += left.reverse().toString();

        return ans;
    }
}
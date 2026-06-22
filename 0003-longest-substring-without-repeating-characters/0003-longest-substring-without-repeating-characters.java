class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            while (list.contains(ch)) {
                list.remove(0);
            }

            list.add(ch);
            max = Math.max(max, list.size());
        }

        return max;
    }
}
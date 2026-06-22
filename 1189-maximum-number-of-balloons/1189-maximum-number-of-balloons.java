class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[26];
        for (int i = 0; i < text.length(); i++) {
            char x = text.charAt(i);
            arr[x - 'a']++;
        }
        arr[11] /= 2;
        arr[14] /= 2;
        return Math.min(
                Math.min(arr[0], arr[1]),
                Math.min(Math.min(arr[11], arr[14]), arr[13]));
    }
}
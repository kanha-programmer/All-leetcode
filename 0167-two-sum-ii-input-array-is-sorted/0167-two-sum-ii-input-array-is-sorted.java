class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=1;i<numbers.length;i++){
            for(int j=i;j<numbers.length;j++){
                if(numbers[j]+numbers[j-i]==target) return new int[]{j-i+1, j+1};
            }
        }
        return  new int[]{};
    }
}
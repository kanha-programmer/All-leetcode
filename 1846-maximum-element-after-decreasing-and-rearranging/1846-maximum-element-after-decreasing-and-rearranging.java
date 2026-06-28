class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int m=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>m){
            m+=1;
            }
        }
        return m;
        
    }
}
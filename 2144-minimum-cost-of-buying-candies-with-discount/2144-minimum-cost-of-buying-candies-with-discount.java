class Solution {
    public int minimumCost(int[] cost) {
       int total = 0;
       int cnt=0;
       Arrays.sort(cost);
       for(int i=cost.length-1; i>=0; i--){
        if(cnt%3!=2){
            total += cost[i];
        }
        cnt++;
       }
       return total; 
    }
}
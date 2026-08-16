class Solution {
    public int maxProduct(int[] nums) {
     int sechigh=0,firhigh=0;
     for(int i=0;i<nums.length;i++) {
        if(nums[i]>firhigh){
            sechigh=firhigh;
            firhigh=nums[i];
        }else if(nums[i]>sechigh){
            sechigh=nums[i];
        }
     } 
     return (firhigh-1) *(sechigh-1);
    }
}
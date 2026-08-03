class Solution {
    public int reverse(int a) {
        int x;
       long y=0;
        while(a!=0){
            x=a%10;
            y=y*10+x;
            a=a/10;
            if(y>Integer.MAX_VALUE || y<Integer.MIN_VALUE ){
                return 0;
            }
        }
        return(int)y;
    }
}
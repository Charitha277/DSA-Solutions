class Solution {
    public int mySqrt(int x) {
        int left= 0;
        int right = x;
        int ans =0 ;
        while(left<= right){
        long  mid = left +(right-left)/2;
            if(mid*mid<=x){
                ans = (int)mid;
                left = (int)mid+1;
            }else{
                right = (int)mid-1;
            }
        }
        return ans;
    }
}
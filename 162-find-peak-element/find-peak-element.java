class Solution {
    public int findPeakElement(int[] nums) {
        int n= nums.length;
        for(int i=0;i<n;i++){
            boolean leftok = (i==0) || (nums[i] > nums[i-1]);
            boolean rightok = (i == (n-1)) || (nums[i] > nums[i+1]);
            if (rightok && leftok){
                return i;
            }
        }
            return -1;
        }
    }

class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n = nums.length;
       for (int i=0;i<n;i++){
        for(int j = i+1; j<n;j++){
            if (nums[j] == target - nums[i]){
                return new int[] { i,j};
            }
        }
       } 
       return null;
    }
}
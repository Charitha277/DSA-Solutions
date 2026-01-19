class Solution {
    public void sortColors(int[] nums) {
        int zeropointer = 0;
        int twopointer = nums.length-1;
        int i = 0;
        while(i<= twopointer){
            if(nums[i] == 0){
                swap(nums,i,zeropointer);
                i++;
                zeropointer++;
            }else if(nums[i] == 2){
                swap(nums,i,twopointer);
                twopointer--;
            }else{
                i++;
            }
        }
    }
    private static void swap(int nums[], int num1 , int num2){
    int temp = nums[num1];
     nums[num1] = nums[num2];
     nums[num2] = temp;
}
}
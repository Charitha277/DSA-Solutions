class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int n = Math.abs(nums[i])-1;
            nums[n] = -1* Math.abs(nums[n]);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0) res.add(i+1);
        }
        return res;
    }
}
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i],hm.get(nums[i])+1);
            }else{
                hm.put(nums[i],1);
            }
        }
        for (int key:hm.keySet()){
            int val = hm.get(key);
            ans = ans + (val* (val-1))/2;
        }
        return ans;
    }
}
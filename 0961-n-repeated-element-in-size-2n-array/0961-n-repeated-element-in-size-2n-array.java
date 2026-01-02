class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet <Integer> set = new HashSet<>();
        for(int n: nums){
            if(set.contains(n)){
                return n;
            }
            set.add(n);
        }
        return -1;
    }
}
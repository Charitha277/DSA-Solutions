class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map <Integer,Integer> freq = new HashMap<>();
        for( int num:nums1){
            freq.put(num,freq.getOrDefault(num,0) +1);
        }
        List <Integer> ans = new ArrayList<>();
    
    for(int num : nums2){
        if(freq.getOrDefault(num,0)>0){
            ans.add(num);
            freq.put(num,freq.get(num)-1);
        }
    }
    return ans.stream().mapToInt(Integer::intValue).toArray();
}
}
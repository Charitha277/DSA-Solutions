class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        curr.add(1);
        res.add(curr);
        while(numRows - 1 != 0){
            List<Integer> next = new ArrayList<>();
            next.add(curr.get(0));
            int n = curr.size();
            for(int i=1;i<n;i++){
                next.add(curr.get(i-1) + curr.get(i));
            }
            next.add(curr.get(n-1));
            curr = next;
            res.add(curr);
            numRows--;
        }
        return res;
    }
}